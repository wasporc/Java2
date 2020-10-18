package ru.geekbrains.java2.models;

public class RunningTrack extends Obstacles{

    public RunningTrack(int length, IActions[] actions) {
        super(length, actions);
    }

    @Override
    public void doAction() {
        for (int i = 0; i < actions.length; i++) {
            if (actions[i] == null) continue;
            boolean pass = actions[i].move(length);
            if (!pass) actions[i] = null;
        }
    }
}
