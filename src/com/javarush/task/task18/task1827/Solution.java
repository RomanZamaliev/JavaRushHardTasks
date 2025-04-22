package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length>0 && args[0].equals("-c")){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String name = bufferedReader.readLine();
            //String name2 = bufferedReader.readLine();

            String rowToAdd = "";
            try(BufferedReader reader = new BufferedReader(new FileReader(name));
                BufferedWriter writer = new BufferedWriter(new FileWriter(name, true))){
                String id = getNewId(reader);

                String product = productFormat(args, id);
                char[] arr = product.toCharArray();
                writer.append("\n");
                for(int i = 0;i< arr.length;i++){
                    writer.append(arr[i]);
                }



            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static String getNewId(BufferedReader reader) throws IOException {

        String row;
        int maxid = 0;
        while((row = reader.readLine()) != null){
            int id;
            String idWithSpaces = row.substring(0, 8);
            if(!(idWithSpaces.indexOf(' ') == -1)){
                id = Integer.parseInt(idWithSpaces.substring(0, idWithSpaces.indexOf(' ')));
            }
            else id = Integer.parseInt(idWithSpaces);
            maxid = Math.max(id, maxid);
        }



        return String.valueOf(maxid + 1);
    }
    public static String productFormat(String[] args, String id){

        if(args.length > 4){
            for(int i = 2;i< args.length - 2;i++){
                args[1] += " " + args[i];
            }
            args[2] = args[args.length - 2];
            args[3] = args[args.length - 1];
            ;
        }

        StringBuilder stringBuilder = new StringBuilder("" + id);
        while(stringBuilder.length() < 8) stringBuilder.append(" ");
        stringBuilder.append(args[1].length() > 30 ? args[1].substring(0,30):args[1]);
        while(stringBuilder.length() < 38) stringBuilder.append(" ");
        stringBuilder.append(args[2]);
        while(stringBuilder.length() < 46) stringBuilder.append(" ");
        stringBuilder.append(args[3]);
        while(stringBuilder.length() < 50) stringBuilder.append(" ");
        return stringBuilder.toString();
    }

}
