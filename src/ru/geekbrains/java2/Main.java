package ru.geekbrains.java2;

import ru.geekbrains.java2.models.*;

/**
 * Все как заказывали.
 * Два массива и все проходят полосы препятсвий если могут.
 */
public class Main {

    public static void main(String[] args) {
        IActions[] actions = {
                new Human(1, 100),
                new Cat(10, 1000),
                new Robot(0,1),
        };

        Obstacles[] obstacles = {
                new Wall(2, actions),
                new RunningTrack(100, actions)
        };

        for (Obstacles obstacle : obstacles) {
            obstacle.doAction();
        }
    }
}
