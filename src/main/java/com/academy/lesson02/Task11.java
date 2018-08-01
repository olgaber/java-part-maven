package com.academy.lesson02;

import java.util.Scanner;

/*Проинициализировать одномерный массив произвольными целыми числами
        Вывести массив в виде:
        [3, 4, 9, 10, 34, 239, 8, 0, -3, 19, 17]
        a) используя цикл for
        b) используя цикл while*/

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 10 natural numbers: ");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        int n4 = scanner.nextInt();
        int n5 = scanner.nextInt();
        int n6 = scanner.nextInt();
        int n7 = scanner.nextInt();
        int n8 = scanner.nextInt();
        int n9 = scanner.nextInt();
        int n10 = scanner.nextInt();

        int[] arr = {n1, n2, n3, n4, n5, n6, n7, n8, n9, n10};

        System.out.println();

        //for
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){

            if (arr[i] == arr[arr.length-1]){
                System.out.print(arr[i]);
            }
            else{
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");

        System.out.println("************************");
        //while

        int count = 0;

        System.out.print("[");
        while (count < arr.length){

            if (arr[count] == arr[arr.length-1]){
                System.out.print(arr[count]);
            }
           else {
                System.out.print(arr[count] + ", ");
            }
            count++;
        }
        System.out.print("]");
    }
}
