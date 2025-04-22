package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()))){
            while(fileReader.ready()){
                bufferedWriter.write(fileReader.readLine().replaceAll("\\p{Punct}", ""));
            }

        }catch (Exception e){

        }
    }
}
