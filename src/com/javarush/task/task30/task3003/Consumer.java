package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    @Override
    public void run() {
        try{
            Thread.sleep(450);
            while(!Thread.currentThread().isInterrupted()){
                ;
                System.out.println("Processing " + queue.take());
            }
        } catch (InterruptedException e) {

        }
    }

    private final TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }
}
