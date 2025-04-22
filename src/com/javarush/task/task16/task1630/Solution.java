package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //напишите тут ваш код
    static {
        Scanner scan = new Scanner(System.in);
        firstFileName = scan.nextLine();
        secondFileName = scan.nextLine();

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface{

        private String fileName;
        private String content = "";
        @Override
        public void setFileName(String fullFileName) {
            fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return content;
        }

        @Override
        public void run() {
            try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
                String line;
                while((line = reader.readLine()) != null){
                    content += line + " ";
                }
            } catch (Exception e) {

            }

        }

    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //напишите тут ваш код
}
