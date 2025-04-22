package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try(FileInputStream inputStream = new FileInputStream(scan.nextLine())){
            int c = 0;
            while(inputStream.available()>0){
                if(',' == (char)inputStream.read()){
                    c++;
                }
            }
            System.out.println(c);
        } catch (Exception e) {

        }

    }
}
