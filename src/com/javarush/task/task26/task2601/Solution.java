package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
        //Arrays.stream(sort(new Integer[]{1,2,3,4,5,6,7,8,9})).forEach(System.out::println);
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int mediana;
        Arrays.sort(array);
        if(array.length%2==1){
            mediana = array[array.length/2];
        }
        else{
            mediana = (array[array.length/2] + array[array.length/2 - 1]) / 2;
        }
        Arrays.sort(array, (e1, e2) -> (Math.abs((int)e1 - mediana) - Math.abs((int)e2 - mediana) == 0? e1-e2:Math.abs((int)e1 - mediana) - Math.abs((int)e2 - mediana)));
        return array;
    }
}
