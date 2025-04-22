package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scan.nextLine());
        HashSet<Integer> set = new HashSet<>();

        while(inputStream.available()>0){
            set.add(inputStream.read());
        }
        Integer[] arr = new Integer[set.size()];
        arr = set.toArray(arr);
        Arrays.sort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        inputStream.close();
    }
}
