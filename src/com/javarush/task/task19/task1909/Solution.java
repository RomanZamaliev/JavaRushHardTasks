package com.javarush.task.task19.task1909;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()))){
            char[] buffer = new char[10000];
            fileReader.read(buffer);
            char[] bufferOut =  String.valueOf(buffer).replaceAll("\\.", "!").toCharArray();
            bufferedWriter.write(bufferOut);

        }catch (Exception e){

        }

    }
}
