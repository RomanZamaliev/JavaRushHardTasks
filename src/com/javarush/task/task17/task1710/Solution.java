package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        switch(args[0]){
            case"-c":
                DateFormat form = new SimpleDateFormat("dd/MM/yyyy");
                Date date = null;
                try{
                    date = form.parse(args[3]);
                } catch (ParseException e) {

                }
                Person person = args[2].equals("ж")? Person.createFemale(args[1], date)
                                                   : Person.createMale(args[1], date);
                allPeople.add(person);
                System.out.println(allPeople.size()-1);
                break;

            case"-r":
                Person personById = allPeople.get(Integer.parseInt(args[1]));
                System.out.println("" + personById.getName() + " " + (personById.getSex()==Sex.MALE?"м":"ж") + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(personById.getBirthDate()));
                break;

            case"-u":
                Person personById2 = allPeople.get(Integer.parseInt(args[1]));
                personById2.setName(args[2]);
                personById2.setSex(args[3].equals("ж")? Sex.FEMALE: Sex.MALE);
                Date date2 = null;
                try{
                    date2 = new SimpleDateFormat("dd/MM/yyyy").parse(args[4]);
                } catch (ParseException e) {
                }
                personById2.setBirthDate(date2);
                break;
            case"-d":
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setName(null);
        }
    }
}
