package ru.geekbrains.java2.models;

public class Wall extends Obstacles{

    public Wall(int length, IActions[] actions) {
        super(length, actions);
    }

    @Override
    public void doAction() {
        for (int i = 0; i < actions.length; i++) {
            if (actions[i] == null) continue;
            boolean pass = actions[i].jump(length);
            if (!pass) actions[i] = null;
        }
    }
}
