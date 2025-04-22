package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
            try(FileInputStream input = new FileInputStream(args[1]);
            FileOutputStream output = new FileOutputStream(args[2])){
                if(args[0].equals("-e")){
                    encrypt(input, output);
                }else if(args[0].equals("-d")){
                    decrypt(input, output);
                }
            } catch (Exception e) {

            }
    }

    public static void encrypt(FileInputStream input, FileOutputStream output) throws IOException {
        byte[] buffer = new byte[input.available()];
        input.read(buffer);
        for(int i = 0;i<buffer.length;i++){
            buffer[i] +=30;
        }
        output.write(buffer);
    }
    public static void decrypt(FileInputStream input, FileOutputStream output) throws IOException {
        byte[] buffer = new byte[input.available()];
        input.read(buffer);
        for(int i = 0;i<buffer.length;i++){
            buffer[i] -=30;
        }
        output.write(buffer);
    }


}
