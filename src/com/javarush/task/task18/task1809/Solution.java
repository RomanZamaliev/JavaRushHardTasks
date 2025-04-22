package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try(FileInputStream input1 = new FileInputStream(scan.nextLine());
            FileOutputStream  output = new FileOutputStream (scan.nextLine())){
               int[] buffer = new int[input1.available()];
                for(int i = 0;i<buffer.length;i++){
                    buffer[i] = input1.read();
                }
                
                for(int i = buffer.length - 1;i>=0 ;i--){
                    output.write(buffer[i]);
//                    System.out.println(buffer[i]);
                }
                
                
            }catch(Exception e){
                
            }
    }


    
}
