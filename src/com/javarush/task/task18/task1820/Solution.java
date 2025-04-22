package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
            FileOutputStream fileOutputStream = new FileOutputStream(bufferedReader.readLine())){
            String doubleNumber;
            ByteArrayOutputStream arr = new ByteArrayOutputStream();
            while(fileInputStream.available() > 0){
                doubleNumber = "";
                char cur;
                while(fileInputStream.available()>0 && (cur = (char)fileInputStream.read())  != ' '){
                    doubleNumber += (char)cur;
                }

                if(fileInputStream.available() > 0){
                    arr.write((Math.round(Double.parseDouble(doubleNumber)) + " ").getBytes());
                }
                else{
                    arr.write((Math.round(Double.parseDouble(doubleNumber)) + "").getBytes());
                }

            }
            arr.writeTo(fileOutputStream);

        }catch (IOException e){

        }

    }
}
