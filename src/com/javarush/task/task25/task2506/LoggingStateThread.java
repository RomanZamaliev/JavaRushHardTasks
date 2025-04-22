package com.javarush.task.task25.task2506;

import java.util.HashSet;
import java.util.Set;

public class LoggingStateThread extends Thread{
    Thread thread;
    LoggingStateThread(Thread thread){
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state = thread.getState();
        System.out.println(state);
        while(thread.getState() != State.TERMINATED){
            State newState;
            if(state != (newState = thread.getState())){
                state = newState;
                System.out.println(state);
            }

        }
        //if(!thread.isAlive()) System.out.println(thread.getState());
    }
}