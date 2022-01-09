package com.samsung.myapplication.java;

import java.util.Scanner;

public class NewMain {
    static int time = 0;

    static String myLock;

    // Сколько времени прошло после запуска программы?
    // --> time
    // <-- прошло 21 сек
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread is started " + Thread.currentThread().getName());


                while (true) {
                    time++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        while (true) {
            System.out.println("Thread is waiting for input " + Thread.currentThread().getName());
            String word = scanner.nextLine();
            if (word.equals("time")) {
                System.out.println("прошло" + time + " сек.");
            }
        }
    }

}
