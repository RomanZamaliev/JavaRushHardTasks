package com.javarush.task.task30.task3010;

import javax.swing.*;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        try {
            int minAvailableBase = 2;
            if (args.length == 0 || args[0].isEmpty()) System.out.println("incorrect");
            String input = args[0];
            if (is36BaseNumber(input)) {
                for (int i = 0; i < input.length(); i++) {
                    int intCountBase;
                    if ((intCountBase = countBase(input.charAt(i))) > minAvailableBase) minAvailableBase = intCountBase;
                }
                System.out.println(minAvailableBase);
            }
            else System.out.println("incorrect");

        } catch (Exception e) {
            System.out.println("incorrect");
        }

        //напишите тут ваш код
    }

    private static boolean is36BaseNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (!(symbol >= 48 && symbol <= 57 ||
                    symbol >= 65 && symbol <= 90 ||
                    symbol >= 97 && symbol <= 122)) {
                return false;
            }
        }
        return true;
    }

    private static int countBase(char a) {
        if (Character.isDigit(a)) {
            return a - 48 + 1;
        } else if (Character.isLowerCase(a)) {
            return a - 97 + 10 + 1;
        }
        return a - 65 + 10 + 1;
    }
}