package com.javarush.task.task26.task2603;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {

    public static void main(String[] args) {

    }
    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;
        public CustomizedComparator(Comparator<T>... comparators){
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int check;
            for(int i = 0;i<comparators.length;i++){
                check = comparators[i].compare(o1, o2);
                if(check != 0){
                    return check;
                }
            }
            return 0;
        }
    }

}



