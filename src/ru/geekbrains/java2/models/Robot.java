package ru.geekbrains.java2.models;

public class Robot implements IActions {
    private final int maxLengthRunning;
    private final int maxLengthJump;

    public Robot(int maxLengthJump, int maxLengthRunning) {
        this.maxLengthJump = maxLengthJump;
        this.maxLengthRunning = maxLengthRunning;
    }

    @Override
    public boolean move(int length) {
        if (length <= maxLengthRunning) {
            System.out.println("Robot move");
            return true;
        } else {
            System.out.println("Robot cant move anymore");
            return false;
        }
    }

    @Override
    public boolean jump(int length) {
        if (length <= maxLengthJump) {
            System.out.println("Robot jump");
            return true;
        } else {
            System.out.println("Robot cant jump anymore");
            return false;
        }
    }
}
