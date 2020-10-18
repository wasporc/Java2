package ru.geekbrains.java2.models;

public abstract class Obstacles {
    protected final int length;
    protected IActions[] actions;

    public Obstacles(int length , IActions[] actions) {
        this.length = length;
        this.actions = actions;
    }

    abstract public void doAction();
}
