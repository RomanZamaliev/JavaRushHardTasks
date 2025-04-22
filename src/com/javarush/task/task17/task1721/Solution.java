package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        try{
            new Solution().joinData();
        } catch (CorruptedDataException e) {

        }
    }

    public void joinData() throws CorruptedDataException {
        String file1;
        String file2;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file1 = reader.readLine();
            file2 = reader.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(Scanner reader1 = new Scanner(new File(file1));
            Scanner reader2 = new Scanner(new File(file2))){
            while(reader1.hasNext()){
                allLines.add(reader1.nextLine());
            }

            while(reader2.hasNext()){
                forRemoveLines.add(reader2.nextLine());
            }

        } catch (Exception e) {

        }
        for(String line:forRemoveLines){
            if(!allLines.remove(line)){
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }
}
