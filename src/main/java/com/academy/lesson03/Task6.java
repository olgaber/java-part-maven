package com.academy.lesson03;

/*
Реализовать программу, которая:
        - считывает строку
        - выводит исходную строку на экран
        - выводит кол-во гласных букв
        - выводит кол-во согласных букв
*/

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();

        System.out.println("Initial string: " + str);

        String vowels = "aeiou";
        char[] vow = vowels.toCharArray();
        char[] input = str.toCharArray();
        int countVowels = 0;
        int countSpaces = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < vow.length ; j++) {

                if (input[i] == vow[j]){
                    countVowels++;
                }
            }

            if (input[i] == ' '){
                countSpaces++;
            }
        }

        System.out.println("Number of vowels: " + countVowels);
        System.out.println("Number of consonants: " + (input.length - countVowels - countSpaces));
        
    }
}
