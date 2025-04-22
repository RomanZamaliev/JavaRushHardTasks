package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scan.nextLine());
        int maxDate = inputStream.read();
        while(inputStream.available() > 0){
            maxDate = Math.min(maxDate, inputStream.read());
        }
        inputStream.close();
        System.out.println(maxDate);
    }
}
