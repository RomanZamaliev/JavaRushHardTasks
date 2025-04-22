package com.javarush.task.task21.task2113;



import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    Hippodrome(List<Horse> horses){
        this.horses = horses;
    }
    static Hippodrome game;

    void run() throws InterruptedException {
        for(int i = 1;i<= 100;i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    void move(){
        for(Horse horse:horses){
            horse.move();
        }

    }
    void print(){
        for(Horse horse:horses){
            horse.print();
        }
        for(int i = 0;i<10;i++) System.out.println();
    }
    public Horse getWinner(){
        return horses.stream().max((a, b) -> (int)(a.distance - b.distance)).orElse(null);
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().name + "!");
    }


    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("плотва1", 3, 0));
        horses.add(new Horse("плотва2", 3, 0));
        horses.add(new Horse("плотва3", 3, 0));
        Hippodrome hippodrome = new Hippodrome(horses);
        Hippodrome.game = hippodrome;
        game.run();
        game.printWinner();


    }
}
