package com.samsung.myapplication.java;

public class MyThread extends Thread {
    public String id;
    public int min;
    public int max;

    public MyThread(String id, int min, int max) {
        this.id = id;
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = min; i < max; i++) {
            System.out.println(id + " is " + i + ".");
        }
    }
}
