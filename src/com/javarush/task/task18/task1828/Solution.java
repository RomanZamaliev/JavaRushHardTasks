package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0 && (args[0].equals("-d") || args[0].equals("-u"))) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String name = bufferedReader.readLine();


            try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
                String row;
                int idToUpdate = Integer.parseInt(args[1]);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                if (args[0].equals("-u")) {
                    while ((row = reader.readLine()) != null) {

                        int id;
                        String idWithSpaces = row.substring(0, 8);
                        //int id = Integer.parseInt(row.substring(0, 8).trim());
                        if (idWithSpaces.indexOf((char)160) != -1) {
                            id = Integer.parseInt(idWithSpaces.substring(0, idWithSpaces.indexOf((char)160)));
                        } else id = Integer.parseInt(idWithSpaces.trim());

                        if (idToUpdate == id) {
                            baos.write((productFormat(args, String.valueOf(id)) + "\n").getBytes());
                        } else {
                            baos.write((row + "\n").getBytes());

                        }
                    }
                }

                if (args[0].equals("-d")) {
                    while ((row = reader.readLine()) != null) {
                        int id;
                        String idWithSpaces = row.substring(0, 8);
                        if (!(idWithSpaces.indexOf(' ') == -1)) {
                            id = Integer.parseInt(idWithSpaces.substring(0, idWithSpaces.indexOf(' ')));
                        } else id = Integer.parseInt(idWithSpaces);

                        if (idToUpdate != id) {
                            baos.write((row + "\n").getBytes());
                        }
                    }
                }

                BufferedWriter writer = new BufferedWriter(new FileWriter(name));
                writer.write(baos.toString());
                writer.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static String productFormat(String[] args, String id) {

        if (args.length > 5) {
            for (int i = 3; i < args.length - 2; i++) {
                args[2] += " " + args[i];
            }
            args[3] = args[args.length - 2];
            args[4] = args[args.length - 1];
            ;
        }

        StringBuilder stringBuilder = new StringBuilder("" + id);
        while (stringBuilder.length() < 8) stringBuilder.append(" ");
        stringBuilder.append(args[2].length() > 30 ? args[2].substring(0, 30) : args[2]);
        while (stringBuilder.length() < 38) stringBuilder.append(" ");
        stringBuilder.append(args[3]);
        while (stringBuilder.length() < 46) stringBuilder.append(" ");
        stringBuilder.append(args[4]);
        while (stringBuilder.length() < 50) stringBuilder.append(" ");
        return stringBuilder.toString();
    }
}
