package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = reader.readLine();
            Movie movie;
            if(str.equals("cartoon")){
                 movie = MovieFactory.getMovie(str);
            }
            else if(str.equals("soapOpera")){
                 movie = MovieFactory.getMovie(str);
            }
            else if(str.equals("thriller")){
                 movie = MovieFactory.getMovie(str);
            }
            else{
                movie = MovieFactory.getMovie(str);
                break;
            }
            System.out.println(movie.getClass().getSimpleName());
        }

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            else if("cartoon".equals(key)){
                movie = new Cartoon();
            }
            else if("thriller".equals(key)) movie = new Thriller();

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }
    static class Cartoon extends Movie{

    }
    static class Thriller extends Movie{

    }

    //Напишите тут ваши классы, пункт 3
}
