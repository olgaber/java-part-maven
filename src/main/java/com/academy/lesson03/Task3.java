package com.academy.lesson03;

/*
Напишите программу, которая:
        - считывает строку
        - считывает подстроку
        - выводит исходные строку и подстроку и выводит кол-во вхождений строки в подстроку
*/

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: "); //Strange string with substring
        String str = scanner.nextLine();

        System.out.println("Initial string: " + str);

        System.out.println("*******************");

        String substr = str.substring(1, 3);
        System.out.println("Substring: "+ "\"" + substr + "\"");

        int count = 0;

        String[] str1 = str.split(" ");

        for (String str2 : str1){
            if (str2.contains(substr)){
                count++;
            }
        }
        System.out.println("Number of substring in the string: " + count);
    }
}
