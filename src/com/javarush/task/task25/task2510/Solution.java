package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/

public class Solution extends Thread {

    public Solution() {
        setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e.getMessage());
                String[] str  =  e.getMessage().split(" ");
                str[1] = str[1].replaceAll("[\\w\\W]", "*");

                System.out.println(String.join(" ", str));

//                if(e.getClass().getSimpleName().contains("Error")){
//                    System.out.println("Нельзя дальше работать");
//                }
//                else if(e.getClass().getSimpleName().contains("Exception")){
//                    System.out.println(e.getMessage());
//                }
//                else{
//                    System.out.println("Поживем - увидим");
//                }
            }
        });
    }

    @Override
    public void run() {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw  new RuntimeException("Blah " + Thread.currentThread().getName() + " blah-blah-blah", new Exception("ajskfdsadf"));
        }
    }

    public static void main(String[] args) {
        new Solution().start();
    }
}
