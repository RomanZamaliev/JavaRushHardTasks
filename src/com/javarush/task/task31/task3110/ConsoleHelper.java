package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleHelper {
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        String line = null;
        try{line = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e){};
        return line;
    }
    public static int readInt() throws IOException{

        return Integer.parseInt(new Scanner(System.in).nextLine());
    }


}
