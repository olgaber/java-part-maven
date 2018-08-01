package com.academy.lesson02;

/*
        a) Инициализировать две переменные. Поменять их значения местами
        b)* Инициализировать две переменные. Поменять их значения местами(не вводя третью)
*/


public class Task3 {
    public static void main(String[] args) {

        //a
        int a = 10;
        int b = 564;
        int c = 0;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        c = a;
        a = b;
        b = c;

        System.out.println("************");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        //b второй вариант xз как


    }
}
