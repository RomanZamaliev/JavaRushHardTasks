package com.javarush.task.task18.task1819;


import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            FileInputStream inputStreamReader1 = new FileInputStream(name);
            FileInputStream inputStreamReader2 = new FileInputStream(reader.readLine());


            byte[] buffer = new byte[inputStreamReader1.available()];
            inputStreamReader1.read(buffer);
            byte[] buffer2 = new byte[inputStreamReader2.available()];
            inputStreamReader2.read(buffer2);


            FileOutputStream fileOutputStream = new FileOutputStream(name);

            fileOutputStream.write(buffer2);
            fileOutputStream.write(buffer);








            inputStreamReader1.close();
            inputStreamReader2.close();
            fileOutputStream.close();


        } catch (IOException e) {

        }


    }
}
