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
    private boolean authenticated = false;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                authenticate();
                if (!authenticated) {
                    disconnect();
                    return;
                }
                
                System.out.println("Клиент авторизован: " + username);
                sendMsg("Добро пожаловать, " + username + "!");
                sendMsg("Ваша роль: " + role);
                
                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.startsWith("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                    } else {
                        server.broadcastMessage(username + ": " + message);
                    }
                }
            } catch (IOException e) {
                System.err.println("Ошибка обработки клиента: " + e.getMessage());
            } finally {
                disconnect();
            }
        }).start();
    }

    private void authenticate() throws IOException {
        sendMsg("Введите логин:");
        String login = in.readUTF();
        sendMsg("Введите пароль:");
        String password = in.readUTF();

        User user = server.getDatabase().authenticate(login, password);
        if (user != null) {
            this.username = user.getUsername();
            this.role = user.getRole();
            this.authenticated = true;
        } else {
            sendMsg("Неверный логин или пароль");
            authenticated = false;
        }
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

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
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
