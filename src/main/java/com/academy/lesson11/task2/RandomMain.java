package com.academy.lesson11.task2;

//Задача на Random
//        - наполнить массив случайными числами от 1 до 15 типа double
//        - округлить до 3 знаков после запятой и сохранить в новый массив (использовать ВigDecimal)
//        - вывести на экран значения исходного массива и округленные значения

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {

        double[] arr = new double[10];
        BigDecimal[] bigArr = new BigDecimal[10];

        Random random = new Random();

        System.out.println("Initial array: ");

        for (int i = 0; i < arr.length ; i++) {

            arr[i] = Math.random()* 16 + 1;
            System.out.println(arr[i]);
            bigArr[i] = BigDecimal.valueOf(arr[i]);

        }
        System.out.println();

        System.out.println("Array with rounding: ");

        for (int i = 0; i <bigArr.length ; i++) {
            bigArr[i] = bigArr[i].setScale(3, RoundingMode.CEILING);
            System.out.println(bigArr[i]);
        }
    }
}
