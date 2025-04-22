package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    @Override
    public void run() {
        try{
            while(!Thread.currentThread().isInterrupted()){
                for(int i = 1;i<10;i++){
                    System.out.println("Элемент 'ShareItem-" + i + "' добавлен");
                    queue.offer(new ShareItem("ShareItem-" + i, i));
                    Thread.sleep(100);
                    if(queue.hasWaitingConsumer()){
                        System.out.println("Consumer в ожидании!");
                    }
                }
            }

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }

    private final TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }
}
