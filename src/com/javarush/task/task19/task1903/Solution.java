package com.javarush.task.task19.task1903;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
//        IncomeData a = new IncomeData() {
//            @Override
//            public String getCountryCode() {
//                return "";
//            }
//
//            @Override
//            public String getCompany() {
//                return "";
//            }
//
//            @Override
//            public String getContactFirstName() {
//                return "Ivan";
//            }
//
//            @Override
//            public String getContactLastName() {
//                return "Ivanov";
//            }
//
//            @Override
//            public int getCountryPhoneCode() {
//                return 0;
//            }
//
//            @Override
//            public int getPhoneNumber() {
//                return 0;
//            }
//        };
//        IncomeDataAdapter in = new IncomeDataAdapter(a);
//        System.out.println(in.getName());

    }

    public static class IncomeDataAdapter implements Customer, Contact{

        private IncomeData data;

        IncomeDataAdapter(IncomeData incomeData){
            data = incomeData;
        }
        @Override
        public String getName() {
            return String.format(data.getContactLastName() + ", " + data.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            String num = String.format("%010d", data.getPhoneNumber());

            return String.format("+%d(%.3s)%s-%s-%s", data.getCountryPhoneCode(),
                    num, num.substring(3, 6), num.substring(6, 8), num.substring(8, 10));
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}