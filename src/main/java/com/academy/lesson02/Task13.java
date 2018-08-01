package com.academy.lesson02;

/*Нарисовать треугольник заданной размерности. Пример для размера 6:
        *
        **
        ***
        ****
        *****
        *******/

import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number: ");
        int size = scanner.nextInt();


        for (int i = size; i >= 0; i--) {
            for (int j = 0; j < size - i; j++)
                System.out.print("*");

            System.out.println();
        }
    }
}