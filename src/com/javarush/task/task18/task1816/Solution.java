package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {

        try(FileInputStream fileInputStream = new FileInputStream(args[0])){

            int c = 0;
            while(fileInputStream.available()>0){
                int cur = fileInputStream.read();
                if(cur >= 'a' && cur <= 'z' ||
                        cur >= 'A' && cur <= 'Z'){
                    c++;
                }
            }
            System.out.println(c);
        } catch (Exception e) {

        }


    }
}
