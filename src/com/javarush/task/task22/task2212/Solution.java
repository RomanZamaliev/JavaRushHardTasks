package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/



public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null || telNumber.length()<10) return false;
        return telNumber.matches("(\\+" +
                "(\\(\\d{3}\\)\\d{9}|" +
                "\\d\\(\\d{3}\\)\\d{8}|" +
                "\\d{2}\\(\\d{3}\\)\\d{7}|" +
                "\\d{3}\\(\\d{3}\\)\\d{6}|" +
                "\\d{4}\\(\\d{3}\\)\\d{5}|" +
                "\\d{5}\\(\\d{3}\\)\\d{4}|" +
                "\\d{6}\\(\\d{3}\\)\\d{3}|" +
                "\\d{7}\\(\\d{3}\\)\\d{2}|" +
                "\\d{8}\\(\\d{3}\\)\\d|" +
                "\\d{12}))|" +

                "(\\(\\d{3}\\)\\d{7}|" +
                "\\d\\(\\d{3}\\)\\d{6}|" +
                "\\d{2}\\(\\d{3}\\)\\d{5}|" +
                "\\d{3}\\(\\d{3}\\)\\d{4}|" +
                "\\d{4}\\(\\d{3}\\)\\d{3}|" +
                "\\d{5}\\(\\d{3}\\)\\d{2}|" +
                "\\d{6}\\(\\d{3}\\)\\d|" +
                "\\d{10})");
    }



    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567")); // true
        System.out.println(checkTelNumber("+38(050)1234567")); // true
        System.out.println(checkTelNumber("(050)1234567")); // true
        System.out.println(checkTelNumber("0(501)234567")); // true
        System.out.println(checkTelNumber("+38)050(1234567")); // false
        System.out.println(checkTelNumber("+38(050)123-45-67")); // false
        System.out.println(checkTelNumber("050ххх4567")); // false
        System.out.println(checkTelNumber("050123456")); // false
        System.out.println(checkTelNumber("(0)501234567")); // false

    }
}

/*public static boolean checkTelNumber(String telNumber) { //без регулярок
        if(telNumber == null || telNumber.length() == 0){
            return false;
        }
        if(telNumber.charAt(0) == '+'){
            return checkTelNumber2(telNumber.substring(1));
        }
        else if(telNumber.charAt(0) == '(' || Character.isDigit(telNumber.charAt(0))){
            return checkTelNumber2(telNumber);
        }
        else return false;
    }
    public static boolean checkTelNumber2(String telNumber){ // принимает 10 или 12 или 14 символов
        if(telNumber.contains("(")){
            if((telNumber.length() - telNumber.replace("(", "").length()) != 1 ||
              (telNumber.length() - telNumber.replace(")", "").length() != 1) ||
              telNumber.indexOf(")") != telNumber.indexOf("(") + 4){
                return false;
            }
            if(telNumber.length() == 12){
                return telNumber.matches("[0-9()]{12}") && Character.isDigit(telNumber.charAt(telNumber.length()-1));
            }
            else if(telNumber.length() == 14){
                return telNumber.matches("[0-9()]{14}") && Character.isDigit(telNumber.charAt(telNumber.length()-1));
            }
            else return false;
        }
        else{
            if(telNumber.length() == 10){
                return telNumber.matches("[0-9]{10}") && Character.isDigit(telNumber.charAt(telNumber.length()-1));
            }
            else if(telNumber.length() == 12){
                return telNumber.matches("[0-9]{12}") && Character.isDigit(telNumber.charAt(telNumber.length()-1));
            }
            else return false;
        }
    }*/
