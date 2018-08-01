package com.academy.lesson03;

/*
 Реализовать программу, которая:
         -принимает строку
         => выводит массив слов, которые содержат символ @

        Например:
        Входная строка:
        "Если возникли вопросы обращайтесь в службу поддержки support@gmail.com или central.office@mail.com"
        Результат:
        [support@gmail.com, central.office@mail.com]
*/

import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();
        String[] words  =  str.split(" ");

        System.out.println("Words that contain '@': ");

        for (int i = 0; i <words.length ; i++) {

            if (words[i].contains("@")){
                System.out.print(words[i] + " ");
            }
        }
    }







}

