package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String string = "roman";
        String substring = "omar";

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        boolean found = false;
        int max = string.length() - substring.length();

        for (int i = 0; i <= max; i++) {
            boolean hasDifferent = false;
            int length = substring.length();
            int j = i;
            int k = 0;
            while (length-- != 0) {
                if (string.charAt(j++) != substring.charAt(k++)) {
                    hasDifferent = true;

                }
            }
            if(!hasDifferent){
                found = true;

            }

        }
        return found;
    }
}

