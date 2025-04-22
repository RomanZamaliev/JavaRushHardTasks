package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scan.nextLine());
        int date;
        while(inputStream.available()>0){
            date = inputStream.read();
            if(map.containsKey(date)) map.replace(date, map.get(date) + 1);
            else{
                map.put(date, 1);
            }
        }
        inputStream.close();
        Optional<Integer> max = map.values().stream().max(Integer::compare);
        int max2 = max.orElse(0);


        for(int key: map.keySet()){
            if(max2 == map.get(key)){
                System.out.print(key + " ");
            }
        }
    }
}
