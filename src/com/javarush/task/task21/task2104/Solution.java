package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return this.first;
    }

    public String getLast() {
        return this.last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;

        if (!Objects.equals(first, solution.first)) return false;
        return Objects.equals(last, solution.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));

//        Solution s1 = new Solution("Donald", "Duck");
//        Solution s2 = new Solution("Donald", "Duck");
//        System.out.println(s1.equals(s2));
//        System.out.println(s.contains(s1));
//        System.out.println(s.contains(s2));

    }
}
