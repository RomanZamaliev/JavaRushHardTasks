package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch(args[0]){
            case"-c":
                synchronized (allPeople){
                    for(int i = 1; i < args.length;i+=3){
                        DateFormat form = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = null;
                        try{
                            date = form.parse(args[i + 2]);
                        } catch (ParseException e) {

                        }
                        Person person = args[i + 1].equals("ж")? Person.createFemale(args[i], date)
                                : Person.createMale(args[i], date);
                        allPeople.add(person);

                        System.out.println(allPeople.indexOf(person));
                    }
                }

                break;

            case"-i":
                synchronized (allPeople){
                    for(int i = 1;i<args.length;i++){
                        Person personById = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println("" + personById.getName() + " " + (personById.getSex()== Sex.MALE ?"м":"ж") + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(personById.getBirthDate()));
                    }
                }


                break;

            case"-u":
                synchronized (allPeople){
                    for(int i = 1;i<args.length;i+=4){
                        Person personById2 = allPeople.get(Integer.parseInt(args[i]));

                        personById2.setName(args[i+1]);
                        personById2.setSex(args[i+2].equals("ж")? com.javarush.task.task17.task1711.Sex.FEMALE : com.javarush.task.task17.task1711.Sex.MALE);
                        Date date2 = null;
                        try{
                            date2 = new SimpleDateFormat("dd/MM/yyyy").parse(args[i+3]);
                        } catch (ParseException e) {
                        }
                        personById2.setBirthDate(date2);
                    }
                }


                break;
            case"-d":
                synchronized (allPeople){
                    for(int i = 1;i<args.length;i++){
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                    }
                }


        }

    }
}
