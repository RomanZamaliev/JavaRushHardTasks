package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int nod;
        while(true){
            if(a<b){
                int tmp = a;
                a = b;
                b = tmp;
            }
            if(a % b == 0){
                nod = b;
                break;
            }
            else a %= b;
        }
        System.out.println(nod);
    }
}
