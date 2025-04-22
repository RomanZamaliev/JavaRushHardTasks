package com.javarush.task.task20.task2027;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };


        for(Word word: detectAllWords(crossword, "home", "same", "fde", "jje", "poe")){
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        char[][] wordsChar = new char[words.length][];
        for(int i = 0;i< words.length;i++){
            wordsChar[i] = new char[words[i].length()];
            wordsChar[i] = words[i].toCharArray();
        }


        for(int i = 0;i<crossword.length;i++){
            for(int j = 0;j<crossword[i].length;j++){
                for(int k = 0;k<words.length;k++){
                    if(crossword[i][j] == wordsChar[k][0]){
                        Integer[] endPos = check(crossword, wordsChar[k], i, j);
                        if(endPos[0] != null){
                            Word word = new Word(String.valueOf(wordsChar[k]));
                            word.setStartPoint(j, i);
                            word.setEndPoint(endPos[1], endPos[0]);
                            list.add(word);
                        }
                    }
                }
            }

        }
        return list;
    }

    public static Integer[] check(int[][] crossword, char[] word, int i, int j){
        Integer[] endPos = new Integer[2];
        boolean same;

        if(j+1 - word.length >=0){ //влево
            same = true;
            int k = 1;
            while(k < word.length){
                if(word[k] != crossword[i][j-k]){
                    same = false;
                    break;
                }
                k++;
            }
            if(same){
                endPos[0] = i;
                endPos[1] = j + 1 - word.length;
                return endPos;
            }
        }
        if(j + word.length <= crossword[0].length){ // вправо
            same = true;
            int k = 1;
            while(k < word.length){
                if(word[k] != crossword[i][j+k]){
                    same = false;
                    break;
                }
                k++;
            }
            if(same){
                endPos[0] = i;
                endPos[1] = j - 1 + word.length;
                return endPos;
            }
        }
        if(i + 1 - word.length >= 0){ //вверх
            same = true;
            int k = 1;
            while(k < word.length){
                if(word[k] != crossword[i - k][j]){
                    same = false;
                    break;
                }
                k++;
            }
            if(same){
                endPos[0] = i + 1 - word.length;
                endPos[1] = j;
                return endPos;
            }
        }
        if(i + word.length <= crossword.length){ //вниз
            same = true;
            int k = 1;
            while(k < word.length){
                if(word[k] != crossword[i + k][j]){
                    same = false;
                    break;
                }
                k++;
            }
            if(same){
                endPos[0] = i - 1 + word.length;
                endPos[1] = j;
                return endPos;
            }

        }
        if(j+1 - word.length >=0 && i + 1 - word.length >= 0){ // вверх влево
            same = true;
            int k = 1;
            while(k < word.length){
                if(word[k] != crossword[i - k][j - k]){
                    same = false;
                    break;
                }
                k++;
            }
            if(same){
                endPos[0] = i + 1 - word.length;
                endPos[1] = j + 1 - word.length;
                return endPos;
            }

        }
        if(j+1 - word.length >=0 && i + word.length <= crossword.length){ //влево вниз
            same = true;
            int k = 1;
            while(k < word.length){
                if(word[k] != crossword[i + k][j-k]){
                    same = false;
                    break;
                }
                k++;
            }
            if(same){
                endPos[0] = i - 1 + word.length;
                endPos[1] = j + 1 - word.length;
                return endPos;
            }

        }
        if(j + word.length <= crossword[0].length && i + 1 - word.length >= 0 ){ //вправо вверх
            same = true;
            int k = 1;
            while(k < word.length){
                if(word[k] != crossword[i-k][j+k]){
                    same = false;
                    break;
                }
                k++;
            }
            if(same){
                endPos[0] = i + 1 - word.length;
                endPos[1] = j - 1 + word.length;
                return endPos;
            }

        }
        if(j + word.length <= crossword[0].length && i + word.length <= crossword.length){ // вправо вниз
            same = true;
            int k = 1;
            while(k < word.length){
                if(word[k] != crossword[i + k][j+k]){
                    same = false;
                    break;
                }
                k++;
            }
            if(same){
                endPos[0] = i - 1 + word.length;
                endPos[1] = j - 1 + word.length;
                return endPos;
            }
        }
        return endPos;

    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
