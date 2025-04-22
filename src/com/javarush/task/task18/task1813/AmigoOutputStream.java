package com.javarush.task.task18.task1813;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream fileOutputStream;
    @Override
    public void close() throws IOException {
        flush();
        String str = "JavaRush © All rights reserved.";
        byte[] buffer = str.getBytes();
        write(buffer);
        fileOutputStream.close();
    }
    public AmigoOutputStream(FileOutputStream output) throws FileNotFoundException {
        super(fileName);
        fileOutputStream = output;
    }

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }
}
