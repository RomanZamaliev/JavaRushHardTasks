package com.javarush.task.task16.task1602;

/* 
My second thread
*/

public class Solution {
    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();
    }
    public static class TestThread extends Thread{
        static{
            System.out.println("it's a static block inside TestThread");
        }

        @Override
        public void run() {
            System.out.println("it's a run method");
        }
    }
//    public static void main(String[] args) {
//         task = new TestThread();
//        new Thread(task).start();
//    }
//    public static class TestThread implements Runnable{
//        @Override
//        public void run() {
//            System.out.println("My first thread");
//        }
//    }
}
