package com.academy.lesson03;

import java.util.Scanner;

/*Реализовать программу, которая:
        - считывает с клавиатуры строку
        - удаляет из строки все цифры
        - выводит исходную строку
        - выводит преобразованную строку
        - выводит список удаленных символов
        */

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();

        System.out.println("Initial string: " + str);

        int count = 0;
        int count1= 0;

        char[] ch = str.toCharArray();

        System.out.println("Numbers in the string: ");

        for (int j = 0; j < ch.length; ++j) {

            if (Character.isDigit(ch[j])) {

                System.out.print(ch[j] + " ");

            }
            else
                count++; // size of array without digits
        }
        System.out.println();
        System.out.println("Size of array without digits: " + count);

        //array without digits

        ///str.replace()

        char[] chNew = new char[count];
        for (int i = 0; i <ch.length ; i++) {
            for (int j = 0; j <chNew.length ; j++) {

                if (!Character.isDigit(ch[i])) {

                    chNew[j] = ch[i];
                }
            }
        }

        System.out.println();
        System.out.println("***************************");

        // print modified array
        System.out.print("Array without digits: ");
        for (char ch1: chNew){
            System.out.print(ch1 + " ");
        }
    }
}




















