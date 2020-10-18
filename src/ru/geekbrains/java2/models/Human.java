package ru.geekbrains.java2.models;

public class Human implements IActions{
    private final int maxLengthRunning;
    private final int maxLengthJump;

    public Human(int maxLengthJump, int maxLengthRunning) {
        this.maxLengthJump = maxLengthJump;
        this.maxLengthRunning = maxLengthRunning;
    }

    @Override
    public boolean move(int length) {
        if (length <= maxLengthRunning){
            System.out.println("Human move");
            return true;
        }
        else {
            System.out.println("Human cant move anymore");
            return false;
        }
    }

    @Override
    public boolean jump(int length) {
        if (length <= maxLengthJump){
            System.out.println("Human jump");
            return true;
        }
        else {
            System.out.println("Human cant jump anymore");
            return false;
        }
    }
}
