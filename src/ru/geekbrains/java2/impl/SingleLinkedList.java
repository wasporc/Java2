package ru.geekbrains.java2.impl;

import ru.geekbrains.java2.GBIterator;
import ru.geekbrains.java2.GBList;

public class SingleLinkedList implements GBList {
    private Node first;
    private int size = 0;

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node();
            first.setVal(val);
            first.setNext(null);
            first.setPrev(null);
        } else {
            add(first, val);
        }
        size++;
    }

    private void add(Node current, String val) {
        if (current.next == null) {
            current.next = new Node();
            current.next.setPrev(current);
            current.next.setNext(null);
            current.next.setVal(val);
            return;
        }
        add(current.next, val);
    }

    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = first.next;
            first.prev = null;
            size--;
            return true;
        }

        Node prev = first;
        Node current = first.next;
        while(current != null) {
            if (current.val.equals(val)) {
                prev.setNext(current.next);
                current.next.setPrev(prev);
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        int i = 0;
        GBIterator iterator = iterator();
        while (iterator.hasNext()) {
            if(i == index) return iterator.next();
            iterator.next();
            i++;
        }
        return null;
    }

    @Override
    public GBIterator iterator() {
        return new StraightForwardIterator(first);
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "first=" + first +
                '}';
    }

    private static class Node {
        private String val;
        private Node prev;
        private Node next;

        public void setVal(String val) {
            this.val = val;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static class StraightForwardIterator implements GBIterator {
        private Node current;

        public StraightForwardIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }

        @Override
        public String prev() {
            String val = current.val;
            current = current.prev;
            return val;
        }
    }
}
