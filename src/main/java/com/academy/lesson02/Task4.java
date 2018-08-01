package com.academy.lesson02;

        //Реализовать программу ввода числа x с клавиатуры и вывода значения: x - 5%

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int x = scanner.nextInt(); //doesn't work if x is double and nextDouble() is used => InputMismatch
        double value = x - 5*x/100;

        System.out.println(x + " - 5 % = " + value);

    }


}
