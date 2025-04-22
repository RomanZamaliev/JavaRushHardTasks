package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 1_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }
        int c = 0;
        for (long i = 0; i < 1_500_000; i++) {
            if(cache.get(i) != null) c++;

        }
        System.out.println(c);
    }
}