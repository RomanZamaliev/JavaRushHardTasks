package com.javarush.task.task19.task1918;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Stack;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {


        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()))){
            char[] a = new char[10000];
            bufferedReader.read(a);
            String text = String.valueOf(a);
            Document document = Jsoup.parse(text,  "", Parser.xmlParser());
            Elements elements = document.select(args[0]);

            for(int i = 0;i<elements.size();i++){
                System.out.println(elements.get(i));
            }
        }catch (Exception e){

        }








//        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()))){
//            char[] a = new char[10000];
//            bufferedReader.read(a);
//            String str = String.valueOf(a);
//            String tag = args[0];
//
//            Stack<Integer> stack = new Stack();
//            stack.push(str.indexOf("<" + tag));
//            int i = stack.peek();
//            ArrayList<String> lines = new ArrayList<>();
//            while(!stack.empty() || str.indexOf("<" + tag, i + 1) != -1){
//                int indexOfOpenTag = str.indexOf("<" + tag, i + 1) == -1 ? Integer.MAX_VALUE: str.indexOf("<" + tag, i + 1);
//                int indexOfCloseTag = str.indexOf("</"+ tag + ">", i + 1);
//                if(indexOfOpenTag < indexOfCloseTag){
//                    stack.push(indexOfOpenTag);
//                    i = indexOfOpenTag;
//                }
//                else{
//                    if(stack.size() > 1){
//                        lines.add(str.substring(stack.pop(), indexOfCloseTag + 7));
//                    }
//                    else if(stack.size() == 1){
//                        System.out.println(str.substring(stack.pop(), indexOfCloseTag + 7));
//                        if(lines.size() > 0){
//                            for(int j = lines.size() - 1;j >=0;j--){
//                                System.out.println(lines.get(j));
//                            }
//                            lines.clear();
//                        }
//
//                    }
//
//                    i = indexOfCloseTag;
//                }
//            }
//
//
//        }catch (Exception e){
//
//        }
    }
}
