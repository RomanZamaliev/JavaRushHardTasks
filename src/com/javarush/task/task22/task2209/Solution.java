package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new FileReader(scan.nextLine()))){
            String str;
            StringBuilder lines = new StringBuilder();
            while((str = reader.readLine()) != null){
                lines.append(str);
            }

            StringBuilder result = getLine(lines.toString().split(" "));
            System.out.println(result.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //...

    }

    public static StringBuilder getLine(String... words) {
        if(words.length == 0) return new StringBuilder();
        StringBuilder result = new StringBuilder(words[words.length - 1]);
        String[] wordsWOFirst = Arrays.copyOf(words, words.length - 1);
        List<String> remained = new ArrayList<>(Arrays.asList(wordsWOFirst));
        while(remained.size() != 0){
            Iterator<String> stringIt = remained.iterator();
            String curStr;
            while(stringIt.hasNext()){
                curStr = stringIt.next();
                if(result.charAt(result.length() -1) == Character.toLowerCase(curStr.charAt(0))){
                    stringIt.remove();
                    result.append(" " + curStr);
                }
            }
        }
        return result;
    }

}
