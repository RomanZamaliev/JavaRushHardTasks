package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{
    static AtomicInteger a = new AtomicInteger(0);
    private void myThreadSetPriority(){
        int maxPrior = this.getThreadGroup().getMaxPriority();
        this.setPriority(a.getAndIncrement() % 10 + 1);

    }
    public MyThread() {
        myThreadSetPriority();
    }

    public MyThread(Runnable task) {
        super(task);
        myThreadSetPriority();
    }

    public MyThread(ThreadGroup group, Runnable task) {
        super(group, task);
        myThreadSetPriority();
    }

    public MyThread(String name) {
        super(name);
        myThreadSetPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        myThreadSetPriority();
    }

    public MyThread(Runnable task, String name) {
        super(task, name);
        myThreadSetPriority();
    }

    public MyThread(ThreadGroup group, Runnable task, String name) {
        super(group, task, name);
        myThreadSetPriority();
    }

    public MyThread(ThreadGroup group, Runnable task, String name, long stackSize) {
        super(group, task, name, stackSize);
        myThreadSetPriority();
    }


}
