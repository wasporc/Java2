package ru.geekbrains.java2.models;

public class Cat implements IActions {
    private final int maxLengthRunning;
    private final int maxLengthJump;

    public Cat(int maxLengthJump, int maxLengthRunning) {
        this.maxLengthJump = maxLengthJump;
        this.maxLengthRunning = maxLengthRunning;
    }

    @Override
    public boolean move(int length) {
        if (length <= maxLengthRunning) {
            System.out.println("Cat move");
            return true;
        } else {
            System.out.println("Cat cant move anymore");
            return false;
        }
    }

    @Override
    public boolean jump(int length) {
        if (length <= maxLengthJump) {
            System.out.println("Cat jump");
            return true;
        } else {
            System.out.println("Cat cant jump anymore");
            return false;
        }
    }
}
