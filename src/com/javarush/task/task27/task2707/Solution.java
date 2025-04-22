package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/

import static java.lang.Thread.sleep;

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here


        Thread checkThread = new Thread() {
            @Override
            public void run() {
                synchronized (o1){
                    try{
                        sleep(500);
                    }catch (InterruptedException e){

                    }
                    synchronized (o2){
                    }
                }

            }
        };
        Thread thread = new Thread() {
            @Override
            public void run() {
                new Solution().someMethodWithSynchronizedBlocks(o1, o2);

            }
        };
        checkThread.setDaemon(true);
        thread.setDaemon(true);

        checkThread.start();
        //sleep(100);
        thread.start();
        sleep(1000);
        if(thread.getState() != Thread.State.BLOCKED){

            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
