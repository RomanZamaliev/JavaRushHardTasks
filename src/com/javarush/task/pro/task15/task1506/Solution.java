package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        var files = Files.readAllLines(Path.of(scan.nextLine()));
        for(int i = 0;i<files.size();i++){
            char[] c = files.get(i).toCharArray();
            for(int j = 0;j<c.length;j++){
                if(c[j] != ' ' && c[j]!=','&& c[j]!='.') System.out.print(c[j]);
            }
            System.out.println();
        }


    }
}

