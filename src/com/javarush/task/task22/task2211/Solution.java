package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String str = "123456789012\\";
        System.out.println(str.matches("\\d{12}\\\\"));
        System.out.println(str);
    }
}
