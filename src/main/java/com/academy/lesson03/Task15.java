package com.academy.lesson03;

/*
 Инициировать массив чисел из 200 элементов:
         а) наполнить массив случайными значениями возрастов от 18 до 60 (желательно использовать Гауссово распределение)
         b) отсортировать массив
         с) вывести минимальное, максимальное значения
         d) вывести кол-во элементов со значением возраста 25
         е) вывести на экран 1-ые десять элементов
*/

import java.util.Arrays;
import java.util.Random;

public class Task15 {
    public static void main(String[] args) {


        int arrSize   = 200;
        int count = 0;

        Random random = new Random();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++){
            arr[i] = random.nextInt(42) + 18;

            if (arr[i] == 25){
                count++;
            }
        }
        System.out.println("Initial array: "+ Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Number of people with age 25 years old: " + count);

        int[] arr1 = Arrays.copyOfRange(arr, 0, 10);
        System.out.println("First 10 elements: " + Arrays.toString(arr1));

        int min = arr[0];
        int max = arr[arr.length-1];

        System.out.println("Minimum value in the array: " + min);
        System.out.println("Maximum value in the array: " + max);
    }


}

