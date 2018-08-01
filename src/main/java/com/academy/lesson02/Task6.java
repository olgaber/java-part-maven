package com.academy.lesson02;

/*Дана последовательность натуральных чисел, в которой все числа парные и только одно непарное (
        напр. [4, 3, 4, 77, 5, 9, 77, 9, 5, 4, 3] - в данной последовательности это число 4).
        Реализовать алгоритм, который из последовательности чисел находит одно непарное число.
        При этом поток последовательности чисел может быть сколь-угодно большим (напр. 2TB данных)
        и мы не можем запоминать и накапливать в буфер числа. Другими словами, алгоритм должен просмотрев
        последовательность чисел однозначно определить непарное число.*/

public class Task6 {
    public static void main(String[] args) {
        int[] testData1 = {4, 3, 4, 77, 5, 9, 77, 9, 5, 443, 3}; //test equivalent classes
        int expected1 = 443;
        System.out.println("Test 1: ");
        testFindUnPair(testData1, expected1);
        System.out.println();

        //all paired
        int[] testData2 = {4, 3, 4, 3, 5, 5, 77, 9, 77, 9};
        int expected2 = 0;
        System.out.println("Test 2: ");
        testFindUnPair(testData2, expected2);
        System.out.println();

        //two values, no unpaired
        int[] testData3 = {-7, -7};
        int expected3 = 0;
        System.out.println("Test 3: ");
        testFindUnPair(testData3, expected3);
        System.out.println();

        //1 unpaired, all negative
        int[] testData4 = {-4, -3, -4, -77, -5, -9, -77, -9, -5, -443, -3};
        int expected4 = -443;
        System.out.println("Test 4: ");
        testFindUnPair(testData4, expected4);
        System.out.println();

        //empty array
        int[] testData5 = {};
        int expected5 = 0;
        System.out.println("Test 5: ");
        testFindUnPair(testData5, expected5);
        System.out.println();

        //unpaired in the beginning
        int[] testData6 = {-23, 4, 3, 4, 3, 5, 5, 77, 9, 77, 9};
        int expected6 = -23;
        System.out.println("Test 6: ");
        testFindUnPair(testData6, expected6);
        System.out.println();

        //unpaired in the end
        int[] testData7 = {-4, -3, -4, -77, -5, -9, -77, -9, -5, -443, -3, -443, 777};
        int expected7 = 777;
        System.out.println("Test 7: ");
        testFindUnPair(testData7, expected7);
        System.out.println();

        //three same numbers
        int[] testData8 = {-4, -4,-4};
        int expected8 = -4;
        System.out.println("Test 8: ");
        testFindUnPair(testData8, expected8);
        System.out.println();

        //three numbers, one unpaired
        int[] testData9 = {0, 55, 55};
        int expected9 = 0;
        System.out.println("Test 9: ");
        testFindUnPair(testData9, expected9);
        System.out.println();

        //one number
        int[] testData10 = {347};
        int expected10 = 347;
        System.out.println("Test 10: ");
        testFindUnPair(testData10, expected10);
        System.out.println();

    }

    public static void testFindUnPair( int[] testData, int expected){

        int actual1 = findUnPair(testData);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual1);

        assert actual1 == expected;// if error, java terminates

        if (actual1 == expected)
        {
            System.out.println("success");
        }
        else
            System.out.println("test failed");
        }

    private static int findUnPair(int [] arr){

        int result = 0;
        for(int n: arr)
            result ^= n;
        return result;
    }
}
