package com.academy.lesson02;

/*Сила тяжести на Луне составляет около 17% земной. Напишите программу, которая
        вычислила бы ваш вес на Луне.*/


import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your weight: ");

        double earthWeight = scanner.nextDouble();

        double moonWeight = 0.17* earthWeight;

        System.out.println("Your weight on the Moon is " + moonWeight +" kg");
    }

}
