package ru.geekbrains.java2;

import ru.geekbrains.java2.impl.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        GBList list = new SingleLinkedList();
        list.add("BMW");
        list.add("TOYOTA");
        list.add("GAZ");
        list.add("TOYOTA");



        /*System.out.println("Size before remove " + list.size());

        boolean isToyotaRemoved = list.remove("TOYOTA");
        System.out.println("Is toyota removed? " + isToyotaRemoved);
        System.out.println("Size after remove " + list.size());*/

        /*GBIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }*/

        System.out.println(list.get(1));
    }
}
