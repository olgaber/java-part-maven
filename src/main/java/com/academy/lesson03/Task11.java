package com.academy.lesson03;
/*
11) Реализовать программу, которая:
        - в диалоговом режиме запрашивает размер массива
        - заполняет массив случайными числами (целые числа)
        - меняет порядок элементов массива
        - сортирует массив
        - выводит исходный массив
        - выводит перевернутый массив
        - выводит отсортированный массив
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a array size: ");
        int arrSize = scanner.nextInt();

        Random random = new Random();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++){
            arr[i] = random.nextInt(100);
        }
        System.out.println("Initial array: "+ Arrays.toString(arr));

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            // swap numbers
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println("Reversed array : " + Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));











    }
}

