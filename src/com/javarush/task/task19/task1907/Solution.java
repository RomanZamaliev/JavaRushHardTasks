package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileReader = new FileReader(reader.readLine())){

            char[] arr = new char[10000];
            fileReader.read(arr);
            String a =  String.valueOf(arr);

            ArrayList<String> arra = new ArrayList<>(Arrays.asList(a.split("[\\p{Punct}\\s]+")));
            System.out.println(arra.stream().filter(e -> e.equals("world")).count());


        }catch (Exception e){

        }
    }
}
