package com.javarush.task.task20.task2024;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* 
Знакомство с графами
*/

public class Solution implements Serializable{
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) {

    }
    private void writeObjects(ObjectOutputStream output) throws IOException {
        output.defaultWriteObject();
        Stack<Solution> stack = new Stack<>();
        HashSet<Solution> set = new HashSet<>();
        stack.push(this);
        output.writeObject(this);

        while(!stack.empty()){
            Solution curr = stack.pop();
            for(Solution edge:curr.edges){
                if(!set.contains(edge)){
                    set.add(edge);
                    stack.push(edge);
                    output.writeObject(edge);
                }
            }
        }

    }
    private void readObjects(ObjectInputStream input){

    }
}
