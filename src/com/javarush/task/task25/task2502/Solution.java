package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here

            wheels  = new ArrayList<Wheel>();
            if(loadWheelNamesFromDB().length == 0 || loadWheelNamesFromDB() == null) throw new UnsupportedOperationException();
            for(String elem:loadWheelNamesFromDB()){
                if(!Arrays.asList(Wheel.values()).contains(Wheel.valueOf(elem)) &&
                   !wheels.contains(Wheel.valueOf(elem))){
                    throw new UnsupportedOperationException();
                }
                wheels.add(Wheel.valueOf(elem));
            }
            if(wheels.size() != 4) throw new UnsupportedOperationException();;
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
}
