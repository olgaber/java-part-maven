package com.academy.lesson02;

import java.util.Scanner;

    //Релизовать программу возведения числа в квадрат

public class Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number: ");
        double n = scanner.nextDouble();
        double d = square(n);
        System.out.println(d);
    }

    private static double square(double n){
        return n*n;
    }
}
