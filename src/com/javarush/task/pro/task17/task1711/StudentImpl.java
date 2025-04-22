package com.javarush.task.pro.task17.task1711;

class StudentImpl implements Student
{
    private String name;
    public StudentImpl(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}