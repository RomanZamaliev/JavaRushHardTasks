package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        while(true){
            String cur = reader.readLine();
            if(cur.equals("user")) doWork(new Person.User());
            else if(cur.equals("loser")) doWork(new Person.Loser());
            else if(cur.equals("coder")) doWork(new Person.Coder());
            else if(cur.equals("proger")) doWork(new Person.Proger());
            else break;
        }



    }

    public static void doWork(Person person) {
        // пункт 3
        if(person instanceof Person.User) ((Person.User) person).live();
        else if(person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        else if(person instanceof Person.Coder) ((Person.Coder) person).writeCode();
        else if(person instanceof Person.Proger) ((Person.Proger) person).enjoy();
    }
}
