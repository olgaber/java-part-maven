package com.academy.Lesson14.task1;

/*Составьте лямбда-выражение, которое возвращает значение true, если
        число принадлежит к диапазону чисел 10-20, включая граничные значения*/

public class NumberClass {

    public static void main(String[] args) {

        int[] intArr = new int [10];

        for (int i = 0; i < intArr.length ; i++) {

            intArr[i] = (int)(Math.random()*100);
            System.out.println(intArr[i]);
        }

        CheckNumber check;
        for (int n: intArr){
            check = (int x) -> x >= 10 && x <= 20;
            boolean result = check.function(n);
            System.out.println("Result for number " + n + " = " + result);
        }
    }
}

interface CheckNumber{

    boolean function(int n);
}
