package com.javarush.task.task25.task2508;

import static java.lang.Thread.sleep;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;
    @Override
    public void run() {
        try{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName());
                sleep(100);
            }
        } catch (InterruptedException e) {
        }

    }

    @Override
    public void start(String threadName) {
        thread = new Thread(new TaskManipulator(), threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
