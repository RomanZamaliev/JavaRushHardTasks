package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        try(RandomAccessFile file = new RandomAccessFile(args[0], "w")){
            int position = Integer.parseInt(args[1]);
            if(file.length() > position){
                file.seek(position);
            }
            else {
                file.seek(file.length());
            }
            file.write(args[2].getBytes());



        } catch (Exception e) {

        }

    }
}
