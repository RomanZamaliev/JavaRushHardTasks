package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);

        var allLines = Files.readAllLines(Paths.get(scan.nextLine()));
        for(int i = 0;i<allLines.size();i+=2){
            System.out.println(allLines.get(i));
        }


        
        
    }
}

