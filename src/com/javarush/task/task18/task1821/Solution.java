package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream(args[0])){
            int[] arr = new int[128];
            Arrays.fill(arr, 0);
            while(fileInputStream.available()>0){
                arr[fileInputStream.read()] +=1;
            }
            for(int i = 0;i<arr.length;i++){
                if(arr[i] > 0){
                    System.out.println( (char)i + " " + arr[i]);
                }
            }

        } catch (Exception e) {

        }
    }
}
