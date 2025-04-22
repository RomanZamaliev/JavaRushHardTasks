package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader fileReader1 = new BufferedReader(new FileReader(reader.readLine()))) {

            String nextStr = null;
            String nextStr1 = null;
            while (fileReader.ready() || fileReader1.ready() || nextStr1 != null || nextStr != null) {
                if (!fileReader.ready()) {
                    lines.add(new LineItem(Type.ADDED, nextStr1));
                    break;
                } else if (!fileReader1.ready()) {
                    lines.add(new LineItem(Type.REMOVED, nextStr));
                    break;
                } else {

                    String str = (nextStr != null ? nextStr : fileReader.readLine());
                    String str1 = (nextStr1 != null ? nextStr1 : fileReader1.readLine());
                    if (str.equals(str1)) {
                        lines.add(new LineItem(Type.SAME, str));
                    } else {
                        if (!fileReader.ready()) {
                            lines.add(new LineItem(Type.ADDED, str1));
                            lines.add(new LineItem(Type.SAME, str));
                            break;
                        } else if (!fileReader1.ready()) {
                            lines.add(new LineItem(Type.REMOVED, str));
                            lines.add(new LineItem(Type.SAME, str1));
                            break;

                        } else {
                            nextStr = fileReader.readLine();
                            nextStr1 = fileReader1.readLine();
                            if (str1.equals(nextStr)) {
                                lines.add(new LineItem(Type.REMOVED, str));
                                lines.add(new LineItem(Type.SAME, str1));
                                nextStr = null;
                            } else if (str.equals(nextStr1)) {
                                lines.add(new LineItem(Type.ADDED, str1));
                                lines.add(new LineItem(Type.SAME, str));
                                nextStr1 = null;
                            }

                        }

                    }


                }
            }

        } catch (Exception e) {

        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
