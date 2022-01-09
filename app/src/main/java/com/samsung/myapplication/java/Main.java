package com.samsung.myapplication.java;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("First", 10, 20);
        MyThread thread2 = new MyThread("Secnd", 10, 20);

        thread1.start();
        thread2.start();

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                System.out.println("LINE1");
                System.out.println("LINE2");
                System.out.println("LINE3");
            }
        };
        thread3.start();

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("OUT1");
                System.out.println("OUT2");
                System.out.println("OUT3");
            }
        });
        thread4.start();


//        thread.start();


//        Scanner scanner = new Scanner(System.in);
//
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        int res = sum(a, b);
//
//        System.out.println(res);
    }
//
//    public static int sum(int a, int b) {
//        return a + b;
//    }
}
