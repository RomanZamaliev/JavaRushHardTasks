package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []

    }
    private static Set<Integer> getRadix(String number){
        Set<Integer> set = new HashSet<>();
        int intNumber;

        try{
            intNumber = Integer.parseInt(number);
            for(int i = 2;i< 37;i++){
                if(isPalindrome(Integer.toString(intNumber, i))){
                    set.add(i);
                }
            }
        }catch (NumberFormatException e){

        }
        finally {
            return set;
        }

    }
    private static boolean isPalindrome(String s){
        for(int i = 0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}