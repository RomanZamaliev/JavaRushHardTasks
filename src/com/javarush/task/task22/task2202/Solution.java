package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        try{
            int firstSpace = string.indexOf(" ");
            int secondSpace = string.indexOf(" ", firstSpace + 1);
            int thirdSpace = string.indexOf(" ", secondSpace + 1);
            int fourthSpace = string.indexOf(" ", thirdSpace + 1);
            if(firstSpace == -1 || secondSpace == -1 || thirdSpace == -1 || fourthSpace == -1){
                throw new StringIndexOutOfBoundsException();
            }
            int fifthSpace;
            if((fifthSpace = string.indexOf(" ", fourthSpace + 1)) != -1){
                return string.substring(firstSpace + 1, fifthSpace);
            }
            return string.substring(firstSpace + 1);



        } catch (Exception e) {
            throw new TooShortStringException(e);
        }

    }

    public static class TooShortStringException extends RuntimeException{
        TooShortStringException(Exception e){
            super(e);
        }
    }
}
