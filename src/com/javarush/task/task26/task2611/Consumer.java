package com.javarush.task.task26.task2611;

import java.util.concurrent.locks.ReentrantLock;

public class Consumer {
    private final ReentrantLock lock = new ReentrantLock();

    public void doSomething() {
        try {
            lock.lock(); // Захватываем блокировку

            // Критическая секция кода
            System.out.println(Thread.currentThread().getName() + " работает...");
            Thread.sleep(1000); // Имитация долгой операции
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Освобождаем блокировку
        }
    }

    public static void main(String[] args) {
        Consumer example = new Consumer();

        // Запускаем два потока, чтобы продемонстрировать работу блокировки
        Thread thread1 = new Thread(() -> example.doSomething(), "Поток 1");
        Thread thread2 = new Thread(() -> example.doSomething(), "Поток 2");

        thread1.start();
        thread2.start();
    }
}