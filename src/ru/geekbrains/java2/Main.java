package ru.geekbrains.java2;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        simpleArrayMethodWithOutThread();
        arrayMethodWithThread();
    }

    public static void simpleArrayMethodWithOutThread(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Расчет в первом методе " + (System.currentTimeMillis() - a));
    }

    public static void arrayMethodWithThread() throws InterruptedException {
        final float[] arr = new float[size];
        final float[] a1 = new float[h];
        final float[] a2 = new float[h];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println("деления одного массива на два " + (System.currentTimeMillis() - a));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long b = System.currentTimeMillis();
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Расчет в первом потоке " + (System.currentTimeMillis() - b));
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long b = System.currentTimeMillis();
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Расчет во втором потоке " + (System.currentTimeMillis() - b));
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        a = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("склейка " + (System.currentTimeMillis() - a));
    }
}
