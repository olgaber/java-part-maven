package com.academy.lesson03;

/*Напишите программу, которая:
        - считывает строку
        - выводит исходную строку
        - выводит количество и список слов, которые начинаются на букву 'd'*/

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        System.out.println(str);

        String[] str1 = str.split(" ");

        int count = 0;

        System.out.println("List of words starting with 'd': ");

        for (String str2: str1){

            if (str2.startsWith("d")) {
                count++;

                System.out.println(str2);
            }
        }
        System.out.println("Number of words starting with 'd': " + count);
    }
}
