package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface{

        private TableInterface tableInterface;
        private String headerText;

        public TableInterfaceWrapper(TableInterface tableInterface){
            this.tableInterface = tableInterface;
        }
        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            tableInterface.setModel(rows);
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            headerText = newHeaderText;
            tableInterface.setHeaderText(newHeaderText);
        }

        @Override
        public String getHeaderText() {

            return tableInterface.getHeaderText().toUpperCase();
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}