package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream(args[0])){
            double all = fileInputStream.available();
            double prob = 0;
            while(fileInputStream.available()>0){
                if(fileInputStream.read() == ' '){
                    prob++;
                }
            }
            System.out.printf("%.2f", prob/all * 100);

        }catch (Exception e){

        }
    }
}
