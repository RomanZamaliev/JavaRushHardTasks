package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {
    Solution(){
        uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Thread.currentThread().interrupt();
        Throwable throwable = e;
        List<Throwable> list= new ArrayList<>();
        while (!(throwable.getCause() == null)) {
            list.add(throwable);
            throwable  = throwable.getCause();
        }
        for(int i = list.size() - 1;i >= 0;i--){
            System.out.println(list.get(i).getCause());
        }
        System.out.println(new Exception(e).getCause());

    }



    public static void main(String[] args) {
        new Solution();
    }
}
