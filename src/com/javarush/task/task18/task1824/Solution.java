package com.javarush.task.task18.task1824;

import java.io.*;
import java.nio.file.*;
import java.nio.file.Path;
import java.util.ArrayList;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String name = "";

        ArrayList<FileInputStream> inputs = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                name = bufferedReader.readLine();
                FileInputStream fileInputStream = new FileInputStream(name);
                inputs.add(fileInputStream);

            }
        }catch(FileNotFoundException e){
            System.out.println(name);


        }
        catch (IOException ignore) {

        }
        for(FileInputStream input:inputs){
            input.close();
        }
    }
}
