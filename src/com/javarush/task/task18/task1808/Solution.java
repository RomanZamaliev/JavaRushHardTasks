package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try(FileInputStream input1 = new FileInputStream(scan.nextLine());
            FileOutputStream  input2 = new FileOutputStream (scan.nextLine());
            FileOutputStream  input3 = new FileOutputStream (scan.nextLine())){
               int[] buffer = new int[input1.available()];
                for(int i = 0;i<buffer.length;i++){
                    buffer[i] = input1.read();
                }
                int i;
                for(i = 0;i< Math.ceil((double) buffer.length/2);i++){
                    input2.write(buffer[i]);
                }
                for(; i<buffer.length;i++){
                    input3.write(buffer[i]);
                }
                
            }catch(Exception e){
                
            }

    }
}
