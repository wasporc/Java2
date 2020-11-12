package ru.geekbrains.java2.auth;

import ru.geekbrains.java2.entity.User;

import java.util.Optional;

public interface AuthenticationService {
    Optional<User> doAuth(String login, String password);
}
