package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Urkaine");
        map.put("city", "Kiev");
        map.put(null, null);
        System.out.println(map.get(null));
        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        if(params == null) return null;
        StringBuilder str = new StringBuilder("");
        for(Map.Entry<String, String> elem:params.entrySet()){
            if(elem.getValue() != null && elem.getKey() != null){
                str.append(String.format("%s = '%s' and ", elem.getKey(), elem.getValue()));
            }

        }
        if(str.length() == 0) return "";
        return str.substring(0, str.length() - 5);
    }
}
