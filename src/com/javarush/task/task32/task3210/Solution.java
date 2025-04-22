package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try(RandomAccessFile file = new RandomAccessFile(args[0], "rw")){
            int position = Integer.parseInt(args[1]);
            if(position > file.length()){
                file.seek(file.length());
                file.write("false".getBytes());
            }
            else{
                file.seek(position);
                byte[] b = new byte[args[2].length()];
                file.read(b, 0, args[2].length());
                file.seek(file.length());
                if(new String(b).equals(args[2])){
                    file.write("true".getBytes());
                }
                else file.write("false".getBytes());
            }


        }catch (Exception e){

        }
    }
}
