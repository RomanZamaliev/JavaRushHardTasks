package com.javarush.task.pro.task18.task1803;

import java.util.Comparator;

/* 
Наставники JavaRush
*/

public class NameComparator implements Comparator<JavaRushMentor>{
    //напишите тут ваш код

    @Override
    public int compare(JavaRushMentor o1, JavaRushMentor o2) {
        return (Integer.compare(o1.getName().length(), o2.getName().length()));
    }
}
