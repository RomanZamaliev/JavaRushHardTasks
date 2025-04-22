package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String cur;
            while (!(cur = bufferedReader.readLine()).equals("exit")){
                new ReadThread(cur).start();
            }
        }catch (Exception e){

        }

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            super(fileName);
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try(FileInputStream inputStream = new FileInputStream(this.getName())){
                int[] arr = new int[128];
                Arrays.fill(arr, 0);
                while(inputStream.available()>0){
                    arr[inputStream.read()]+=1;
                }
                int max = 0, freqByte = 0;
                for(int i = 0;i<arr.length;i++){
                    if(arr[i] > max){
                        freqByte = i;
                        max = arr[i];
                    }
                }
                resultMap.put(this.getName(), freqByte);

            }catch (Exception e){

            }

        }
    }
}
