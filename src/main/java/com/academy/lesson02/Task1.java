package com.academy.lesson02;


/*Написать программу ввода с клавиатуры последовательно 3 чисел. Вывести
        минимальное максимальное и средние значения*/

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        int n = scanner.nextInt();
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        //minimum value
        if (n <= n1 && n <= n2)
            System.out.println(n + " is a minimum value");

        else if (n1 <= n && n1 <= n2)
            System.out.println(n1 + " is a minimum value");

        else
            System.out.println(n2 + " is a minimum value");

        //maximum value
        if (n >= n1 && n >= n2)
            System.out.println(n + " is a maximum value");

        else if (n1 >= n && n1 >= n2)
            System.out.println(n1 + " is a maximum value");

        else
            System.out.println(n2 + " is a maximum value");

        //average value

        int average = (n + n1 +n2)/3;
        System.out.println(average + " is an average value");
    }
}
