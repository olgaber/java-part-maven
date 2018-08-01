package com.academy.lesson03;
/*
Реализовать программу, которая определяет, является ли строка палиндромом.
        Палиндром - это строка, которая одинаково читается одинаково в обоих направлениях
        (пример: "мадам" - палиндром, "адам" - не палиндром).
*/

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();

        StringBuffer buffer = new StringBuffer(str);

        System.out.println("Initial string: " + buffer);

        StringBuffer buffer1= buffer.reverse();

        System.out.println("Reversed string: " + buffer1);

        if (str.equals(buffer1.toString())){
            System.out.println("The string is a palindrom");
        }
        else{
            System.out.println("The string isn't a palindrom");
        }

    }
}
