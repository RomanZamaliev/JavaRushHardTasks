package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try(Scanner scan = new Scanner(System.in);
            BufferedWriter writer = new BufferedWriter(new FileWriter(scan.nextLine()))){
                String str;
                while(true){
                    str = scan.nextLine();
                    if(str.equals("exit")) break;
                    writer.write(str + "\n");
                }
                writer.write(str);


            } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
