package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.*;

/*
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            RandomAccessFile fileOutputStream = new RandomAccessFile(new File(bufferedReader.readLine()), "rw");
            FileInputStream fileInputStream1 = new FileInputStream(bufferedReader.readLine());
            FileInputStream fileInputStream2 = new FileInputStream(bufferedReader.readLine())){
//            int offset = fileInputStream1.available();

            byte[] buffer = new byte[fileInputStream1.available()];
            byte[] buffer2 = new byte[fileInputStream2.available()];
            fileInputStream1.read(buffer);
            fileInputStream2.read(buffer2);




            fileOutputStream.write(buffer);
            fileOutputStream.seek(buffer.length);
            fileOutputStream.write(buffer2);




        }catch (Exception e){

        }

    }
}
