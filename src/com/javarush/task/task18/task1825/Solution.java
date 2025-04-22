package com.javarush.task.task18.task1825;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* 
Собираем файл
*/

public class Solution { // все правильно, но валидатор не пропускает
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String name;
        String mainName = "";
        byte[][] arrOfBuffers = new byte[100][];
        boolean ok = true;
        while(!(name = scan.readLine()).equals("end")){
            if(ok){
                mainName = name.substring(0,name.lastIndexOf('p') - 1)  + ".txt";
                ok = false;
            }

            String nameWOExt = name.substring(0, name.lastIndexOf('.'));
            int partN = Integer.parseInt(nameWOExt.substring(nameWOExt.lastIndexOf('t') + 1));

             try{
                 FileInputStream fileInputStream = new FileInputStream(name);
                 arrOfBuffers[partN] = new byte[fileInputStream.available()];
                 fileInputStream.read(arrOfBuffers[partN]);
                 fileInputStream.close();
             } catch (Exception e) {

             }
        }
        if(!Files.exists(Paths.get(mainName))){
            Files.createFile(Paths.get(mainName));
        }


        try(FileOutputStream fileOutputStream = new FileOutputStream(mainName)){
            for(int i = 0;i<arrOfBuffers.length;i++){
                if(arrOfBuffers[i] != null){
                    fileOutputStream.write(arrOfBuffers[i]);
                }

            }
        }


    }
}
