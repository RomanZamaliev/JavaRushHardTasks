package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try(Scanner scan = new Scanner(System.in);
            FileInputStream input = new FileInputStream(scan.nextLine());
            Scanner sc = new Scanner(input)){
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(sc.hasNextInt()){

                list.add(sc.nextInt());
            }
            list.stream().filter(x->x%2==0).sorted().forEach(x -> System.out.println(x));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
