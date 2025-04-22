package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
        int raz1 = url.indexOf('?') + 1;
        int raz2 = url.indexOf('&');
        int flag = 0;
        while(raz1 != 0){
            String par = url.substring(raz1, raz2 == -1?url.length():raz2);
            if(par.contains("obj")) flag = 1;
            System.out.print((par.contains("=")?par.substring(0, par.indexOf('=')):par) + " ");
            raz1 = raz2 + 1;
            raz2 = raz2 == -1?-1: url.indexOf('&', raz2 + 1);

        }
        System.out.println();
        if(flag == 1){
            try{
                alert(Double.parseDouble(url.substring(url.indexOf('=') + 1, url.indexOf('&'))));
            } catch (NumberFormatException e) {
                alert(url.substring(url.indexOf('=') + 1, url.indexOf('&')));
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
