package com.javarush.task.pro.task15.task1516;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            if(Files.isRegularFile(Path.of(str))) System.out.println(str + THIS_IS_FILE);
            else if(Files.isDirectory(Path.of(str))) System.out.println(str + THIS_IS_DIR);
            else break;
        }
    }
}

