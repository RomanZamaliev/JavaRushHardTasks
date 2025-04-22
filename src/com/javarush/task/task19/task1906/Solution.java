package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        try(
            FileReader reader = new FileReader(scanner.readLine());
            FileWriter writer = new FileWriter(scanner.readLine())){
            int c = 1;
            while (reader.ready()){
                if(c%2==0){
                    writer.write(reader.read());
                }
                else{
                    reader.read();
                }
                c++;
            }
            scanner.close();

        }catch (Exception e){

        }
        //scanner.close();

    }
}
