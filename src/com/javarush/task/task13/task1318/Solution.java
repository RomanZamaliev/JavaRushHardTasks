package com.javarush.task.task13.task1318;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            FileInputStream input = new FileInputStream(reader.readLine());
//            Scanner sc = new Scanner(input);
            BufferedReader a = new BufferedReader(new FileReader(reader.readLine()))){
            String line;
            while((line = a.readLine()) != null){
                System.out.println(line);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}