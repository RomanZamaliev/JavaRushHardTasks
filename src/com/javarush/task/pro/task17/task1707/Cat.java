package com.javarush.task.pro.task17.task1707;

public class Cat extends Pet {
    public static final String CAT = "Я не люблю людей.";

    //напишите тут ваш код
    public void printInfo(){
        super.printInfo();
        System.out.println(CAT);
    }

}
