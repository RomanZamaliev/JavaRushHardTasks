package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        String name = "Иванов Иван Иванович 31 12 1950";
        PersonScanner personScanner  = new PersonScannerAdapter(new Scanner(name));
        Person a = personScanner.read();
    }

    public static class PersonScannerAdapter  implements PersonScanner{
        private Scanner fileScanner;
        PersonScannerAdapter(Scanner scanner){
            fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String curString = fileScanner.nextLine();
            String[] split = curString.split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(split[5]), Integer.parseInt(split[4]) - 1, Integer.parseInt(split[3]));
            Date date = calendar.getTime();
            return new Person(split[1], split[2], split[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
