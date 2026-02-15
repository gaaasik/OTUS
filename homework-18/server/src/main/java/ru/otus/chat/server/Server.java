package ru.otus.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHandler> clients;
    private DatabaseService database;

    public Server(int port) {
        this.port = port;
        clients = new CopyOnWriteArrayList<>();
        database = new DatabaseService();
    }

    public void start(){
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запустился на порту: " + port);
            while (true){
                Socket socket = serverSocket.accept();
                subscribe(new ClientHandler(socket, this));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            database.close();
        }
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        if (clientHandler.getUsername() != null) {
            System.out.println("Клиент " + clientHandler.getUsername() + " отключился");
        }
        clients.remove(clientHandler);
    }

    public void broadcastMessage(String message){
        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    public DatabaseService getDatabase() {
        return database;
    }
}
