package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new FileReader(scan.nextLine()))) {
            String str, lines = "";
            while((str = reader.readLine()) != null){
                lines += str;
            }
            StringBuilder[] stringBuilder = new StringBuilder[lines.split(" ").length];
            String finalLines = lines;
            Arrays.setAll(stringBuilder, i -> new StringBuilder(finalLines.split(" ")[i]));

            for(int i = 0;i< stringBuilder.length - 1;i++){
                StringBuilder currRev = stringBuilder[i].reverse();
                for(int j = i + 1;j<stringBuilder.length;j++){
                    if(currRev.toString().equals(stringBuilder[j].toString())){
                        Pair pair = new Pair();
                        pair.first = currRev.reverse().toString();
                        pair.second = stringBuilder[j].toString();
                        if(!result.contains(pair)){
                            result.add(pair);
                        }
                    }
                }
            }
            result.forEach(e -> System.out.println(e.first + " " + e.second));
        }catch (Exception e){

        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
