package com.academy.lesson03;

/*
Корректор*
        Ввести с клавиатуры строку. Удалить лишние пробелы, в том числе начальные и конечные.
        Внутри слов большие буквы заменить маленькими. Если перед словами, начинающимися с большой буквы,
        нет точки, добавить точку в конце предшествующих слов.
        Сформировать и вывести на экран слова, начинающиеся на мягкий знак.
*/

//NOT FINISHED

import java.util.Scanner;

public class Task8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();
        System.out.println("Initial string: " + str);
        String str1 = str.trim(); //spaces removed
        System.out.println("String without spaces: " + str1);
        String str2 = str1.toLowerCase();
        System.out.println(str2);
        System.out.println("***************");









    }






}

