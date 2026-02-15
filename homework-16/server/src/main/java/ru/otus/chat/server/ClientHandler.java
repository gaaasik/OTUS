package ru.otus.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;

    private String username;
    private Role role;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        username = "user" + socket.getPort();
        
        // Первый подключившийся клиент — ADMIN, остальные — USER
        if (server.isFirstClient()) {
            role = Role.ADMIN;
        } else {
            role = Role.USER;
        }

        new Thread(() -> {
            System.out.println("Клиент подключился " + socket.getPort());
            sendMsg("Вы подключились с ником: " + username);
            sendMsg("Ваша роль: " + role);
            try {
                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.startsWith("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                        // Обработка команды /kick (только для ADMIN)
                        if (message.startsWith("/kick ")) {
                            if (role == Role.ADMIN) {
                                String[] tokens = message.split(" ", 2);
                                if (tokens.length == 2) {
                                    String targetUsername = tokens[1];
                                    server.kickUser(username, targetUsername);
                                } else {
                                    sendMsg("Неверный формат команды. Используйте: /kick username");
                                }
                            } else {
                                sendMsg("У вас нет прав для использования команды /kick");
                            }
                        }
                        // Обработка команды /w nick message
                        if (message.startsWith("/w ")) {
                            String[] tokens = message.split(" ", 3);
                            if (tokens.length == 3) {
                                String targetNick = tokens[1];
                                String privateMessage = tokens[2];
                                server.sendPrivateMessage(username, targetNick, privateMessage);
                            } else {
                                sendMsg("Неверный формат команды. Используйте: /w nick сообщение");
                            }
                        }
                    } else {
                        server.broadcastMessage(username + ": " + message);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
