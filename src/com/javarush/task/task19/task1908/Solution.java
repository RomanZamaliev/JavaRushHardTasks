package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()))){
            char[] buffer = new char[10000];
            fileReader.read(buffer);
            String[] arrStr =  String.valueOf(buffer).trim().split(" ");
            for(String str:arrStr){
                try{
                    bufferedWriter.write(Integer.parseInt(str) + " ");
                    //bufferedWriter.write(" ");
                }catch (Exception ignore){

                }
            }

        }catch (Exception e){

        }
    }
}
