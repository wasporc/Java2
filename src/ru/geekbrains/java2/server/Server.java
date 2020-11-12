package ru.geekbrains.java2.server;

import ru.geekbrains.java2.auth.AuthenticationService;

public interface Server {
    void broadcastMessage(String message);
    boolean isLoggedIn(String nickname);
    void subscribe(ClientHandler client);
    void unsubscribe(ClientHandler client);
    AuthenticationService getAuthenticationService();
    boolean whisper(String message, String toClientName);
}
