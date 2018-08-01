package com.academy.lesson02;

/*Вывести ромб заданной размерности. Пример для размера 3:
        1
       121
      12321
       121
        1
 */

import java.util.Scanner;

public class Task12 {


    public static void main(String[] args) {

        int noOfColumns = 1;
        int start = 0; //number of row

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the width of the rhombus: ");
        int size = scanner.nextInt();
        int middle = size/2 + 1;
        int noOfSpaces = size/2;

        for (int i = 1; i <= size; i++){

            for (int j = 1; j <= noOfSpaces; j++){
                System.out.print(" ");
            }
            if (i < middle){
                start = i; // up to and for middle row: row number = i
                noOfSpaces--;
            }
            else{
                start = size + 1 - i; // after middle row: row number = (size +1) - i
                noOfSpaces++;
            }

            for (int j = 1; j<= noOfColumns; j++ ){

                int middleColumn = noOfColumns/2 + 1;
                System.out.print(start); // print numbers
                if (j < middleColumn){
                    start--; //decrease number by one for each next column up to and for middle column
                }
                else
                {
                    start++; // increase number by one after middle column
                }
            }
            System.out.println();

            if (i < middle)
            {
                noOfColumns = noOfColumns + 2;
            }
            else {
                noOfColumns = noOfColumns - 2;
            }
        }
    }
}
