package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "output";
            //Add your code here
            if(author.equals("Mark Twain")) return markTwainOutput;
            else if(author.equals("Agatha Christie")) return agathaChristieOutput;

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book{
        private String title;
        private static final String author = "Mark Twain";
        public MarkTwainBook(String title){
            super(author);
            this.title = title;
        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }
        public String getTitle(){
            return title;
        }
    }
    public static class AgathaChristieBook extends Book{
        private String title;
        private static final String author = "Agatha Christie";
        public AgathaChristieBook(String title){
            super(author);
            this.title = title;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }
        public String getTitle(){
            return title;
        }
    }
}
