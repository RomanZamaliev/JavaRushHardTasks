package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        System.out.println(hen.getCountOfEggsPerMonth());
        System.out.println(hen.getDescription());

    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = (country == Country.BELARUS ? new BelarusianHen() :
                       country == Country.MOLDOVA ? new MoldovanHen() :
                       country == Country.RUSSIA ? new RussianHen() :
                       country == Country.UKRAINE ? new UkrainianHen() : null);
            return hen;


        }
    }


}
