package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;
    FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }
    FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }
    FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }
    FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }
    FileConsoleWriter(FileDescriptor fileDescriptor){
        fileWriter = new FileWriter(fileDescriptor);
    }

    public void write(char[] cbuf, int off, int len) throws IOException{
        fileWriter.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off, len + off));
    }
    public void write(int c) throws IOException{
        fileWriter.write(c);
        System.out.println((char)c);
    }
    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException{
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, len + off));
    }
    public void write(char[] cbuf) throws IOException{
        fileWriter.write(cbuf);
        System.out.println(String.valueOf(cbuf));
    }
    public void close() throws IOException{
        fileWriter.close();
    }


    public static void main(String[] args) {

    }

}
