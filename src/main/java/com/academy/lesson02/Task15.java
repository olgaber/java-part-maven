package com.academy.lesson02;

/*Нарисовать квадрат заданной размерности. Пример для размера 4:
        ****
        *  *
        *  *
        ****
 */

import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++){
            for (int j = 0; j <n; j++){
                if ((i == 0 || i == n - 1)||(j==0 || j == n - 1)){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
