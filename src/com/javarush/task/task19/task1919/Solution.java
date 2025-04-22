package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/*
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        TreeMap<String, Double> salary = new TreeMap<>();

        String fileName = args[0];

        try (BufferedReader rd = new BufferedReader(new FileReader(fileName))) {
            String[] splitedLine;
            String line;
            Double currentValue;

            while ((line = rd.readLine()) != null) {
                splitedLine = line.split(" ");
                String name = splitedLine[0];
                double value = Double.parseDouble(splitedLine[1]);

                if (salary.containsKey(name)) {
                    currentValue = salary.get(name);
                    salary.put(name, value + currentValue);
                } else {
                    salary.put(name, value);
                }
            }
        } catch (IOException ignore) {
            /*NOP */
        }

        for (String key : salary.keySet()) {
            System.out.println(key + " " + salary.get(key));
        }
    }
}










































//сортировка по значению

//package com.javarush.task.task19.task1919;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//
///*
//Считаем зарплаты
//*/
//
//public class Solution {
//    public static void main(String[] args) {
//        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
//            HashMap<String, Double> map = new HashMap<>();
//            String str;
//            while((str = reader.readLine()) != null){
//                String name = str.split(" ")[0];
//                Double value = Double.parseDouble(str.split(" ")[1]);
//                if(map.containsKey(name)){
//                    map.put(name, map.get(name) + value);
//                }
//                else{
//                    map.put(name, value);
//                }
//            }
//           for(Map.Entry<String, Double> elem: entriesSortedByValues(map)){
//               System.out.println(elem.getKey() + " " + elem.getValue());
//           }
//
//        }catch (Exception e){
//
//        }
//
//
//    }
//    static SortedSet<Map.Entry<String,Double>> entriesSortedByValues(Map<String,Double> map) {
//        SortedSet<Map.Entry<String,Double>> sortedEntries = new TreeSet<Map.Entry<String,Double>>(
//                new Comparator<Map.Entry<String,Double>>() {
//                    @Override public int compare(Map.Entry<String,Double> e1, Map.Entry<String,Double> e2) {
//                        int res = e1.getValue().compareTo(e2.getValue());
//                        return res;
//                    }
//                }
//        );
//        sortedEntries.addAll(map.entrySet());
//        return sortedEntries;
//    }
//}
