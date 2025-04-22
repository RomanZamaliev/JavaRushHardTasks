package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {

        ArrayList<Long> list = new ArrayList<>();
        int[] uniqSeq = new int[String.valueOf(N).length()];
        Arrays.fill(uniqSeq, 9);


        Long[][] map = new Long[10][String.valueOf(N).length()+ 1];
        Arrays.fill(map[0], 0L);


        while(uniqSeq[uniqSeq.length - 1] != 0){
            long number = Long.parseLong(Arrays.toString(uniqSeq).substring(1, Arrays.toString(uniqSeq).length() - 1).replace(", ", ""));
            long answer = 0;
            int place = String.valueOf(number).length();
            while(number != 0){
                int razryad = (int) (number % 10);
                if(map[razryad][place] == null){
                    map[razryad][place] = (long)Math.pow(razryad, place);
                }
                answer += map[razryad][place];
                number/=10;
            }

            long answer2 = 0;
            number = answer;
            while(number != 0){
                int razryad = (int) (number % 10);
                if(map[razryad][place] == null){
                    map[razryad][place] = (long)Math.pow(razryad, place);
                }
                answer += map[razryad][place];
                number/=10;
            }
            if(answer == answer2){
                list.add(answer);
            }


            uniqSeq[0]--;
            int i = 0;
            while(uniqSeq[i] == 0 && i != String.valueOf(N).length()){
                uniqSeq[i+1]--;
                i++;
            }


        }
        long[] arr = new long[list.size()];
        for(int i = 0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }



    public static void main(String[] args) throws InterruptedException {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100_000_000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
//1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54 748, 92 727, 93 084, 548 834, 1 741 725, 4 210 818, 9 800 817, 9 926 315, 24 678 050, 24 678 051, 88 593 477, 146 511 208, 472 335 975, 534 494 836, 912 985 153, 4 679 307 774.
//[1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834]

/*
public static long[] getNumbers(long N) { //без уникальных последовательностей

        ArrayList<Long> list = new ArrayList<>();



        Long[] map = new Long[10];
        for(long i = 1;i<N; i++){
            long number = i;
            long answer = 0;
            int place = String.valueOf(number).length();
            while(number != 0){
                int razryad = (int) (number % 10);
                if(map[razryad] == null){
                    map[razryad] = (long)Math.pow(razryad, place);
                }
                answer += map[razryad];
                number/=10;
            }
            if(i == answer){
                list.add(answer);
            }
            if(String.valueOf(i + 1).length() > String.valueOf(i).length()) Arrays.fill(map, null);
        }

        long[] arr = new long[list.size()];
        for(int i = 0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }*/