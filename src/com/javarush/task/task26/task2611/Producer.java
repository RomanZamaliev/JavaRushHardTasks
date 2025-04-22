package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.sleep;

public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        try{
            int i = 1;
            while (true) {
                map.put(String.valueOf(i), "Some text for " + i);
                i++;
                sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println(currentThread.getName() + " thread was terminated");
        }


    }
}
