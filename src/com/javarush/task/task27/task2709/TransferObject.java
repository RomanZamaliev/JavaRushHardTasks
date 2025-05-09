package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get(){
        try {
            while (!isValuePresent) {
                this.wait();
            }
        }catch (InterruptedException e){

        }
        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value) {

        this.value = value;
        System.out.println("Put: " + value);
        isValuePresent = true;
        this.notify();
    }
}
