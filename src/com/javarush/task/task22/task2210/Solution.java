package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTok = new StringTokenizer(query, delimiter);

        String[] result = new String[stringTok.countTokens()];
        int i = 0;
        while(stringTok.hasMoreTokens()){
            result[i++] = stringTok.nextToken();
        }
        return result;
    }
}
