package com.javarush.task.task20.task2023;

/* 
Делаем правильный вывод
*/
/*Для всех методов Java используется механизм позднего связывания,
 если только метод не был объявлен как private. Вызов private метода
 компилируется в инструкцию байт-кода invokespecial, которая вызывает
 реализацию метода из конкретного класса, определенного в момент компиляции.
  Вызов метода с другим уровнем доступа компилируется в invokevirtual,
  которая уже смотрит на тип объекта по ссылке в момент исполнения.
  Финальные неприватные методы тоже вызываются через invokevirtual*/

public class Solution {
    public static void main(String[] s) {
        A a = new C();
        a.method2();
    }

    public static class A {
        private void method1() {
            System.out.println("A class, method1");
        }

        public void method2() {

            System.out.println("A class, method2");
            System.out.println(this.getClass().getSimpleName());
            method1();
        }
    }

    public static class B extends A {
        public void method1new()
        {
            super.method2();
            System.out.println("B class, method1");

        }

        public void method2() {
            System.out.println("B class, method2");
        }
    }

    public static class C extends B {
        public void method1() {
            System.out.println("C class, method1");
        }

        public void method2() {
            System.out.println("C class, method2");
            super.method1new();
        }
    }
}
