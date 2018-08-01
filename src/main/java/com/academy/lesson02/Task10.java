package com.academy.lesson02;

/*Заполнить одномерный целочисленный массив значениями от 1 до 10 включительно.
        Одномерный массив вывести в строку в виде:
        [3, 4, 9, 10, 1, 2, 8, 10, 3, 1, 7]*/

import java.util.Arrays;
import java.util.Random;

public class Task10 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++){
            arr[i] = random.nextInt(10) + 1; //
        }
        System.out.println(Arrays.toString(arr));

    }
}
