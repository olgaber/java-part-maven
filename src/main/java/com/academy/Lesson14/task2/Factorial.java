package com.academy.Lesson14.task2;

/*Создайте блочное лямбда-выражение для вычисления факториала целого числа.
        Продемонстрируйте его использование.*/

public class Factorial {

    public static void main(String[] args) {
        FactorialInt factorial = n -> {

            int fact = 1;

            for (int i = 1; i <= n; i++) {

                fact *= i;

            }
            return fact;

        };

        System.out.println("Factorial for number '7' = " + factorial.function(7));
    }

}

interface FactorialInt{
    int function(int n);
}
