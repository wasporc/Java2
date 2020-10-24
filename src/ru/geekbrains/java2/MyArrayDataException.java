package ru.geekbrains.java2;

public class MyArrayDataException extends IllegalArgumentException {
    public MyArrayDataException() {
    }

    public MyArrayDataException(String s) {
        super(s);
    }

    public MyArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
