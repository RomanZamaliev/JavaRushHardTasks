package com.javarush.task.task27.task2703;

import static java.lang.Thread.sleep;

public class Solution {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void bow(Friend bower) throws InterruptedException {
            synchronized (this) { // Захватываем мьютекс текущего объекта
                System.out.format("%s: %s bowed to me!%n", this.name, bower.getName());

                bower.bowBack(this);
            }
        }

        public void bowBack(Friend bower) {
            synchronized (this) { // Захватываем мьютекс текущего объекта
                System.out.format("%s: %s bowed back to me!%n", this.name, bower.getName());
            }
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        new Thread(() -> {
            try {
                alphonse.bow(gaston);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                gaston.bow(alphonse);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}