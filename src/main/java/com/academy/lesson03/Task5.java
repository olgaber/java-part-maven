package com.academy.lesson03;

/*Реализовать программу, которая:
        - считывает строку /+
        - меняет местами порядок символов (напр. "abcd" => "dcba")
        - выводит исходную строку /+
        - выводит перевернутую строку*/

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();

        System.out.println("Initial string: " + str);

        StringBuffer buffer = new StringBuffer(str);

        buffer.reverse();

        System.out.println("Reversed string: " + buffer.toString());

    }
}
