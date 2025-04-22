package com.javarush.task.task18.task1822;

import java.io.*;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        String id = args[0];
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()))){
            while(reader.ready()){
                String cur = reader.readLine();
                if(cur.startsWith(id + " ")){
                    System.out.println(cur);
                }
            }

        }catch (Exception e){

        }

    }
}
