package com.academy.lesson13.task2;

/*      +a) создать список целых чисел
        +b) наполнить список случайными целыми числами от 1 до 100 (размер списка 20 элементов)
        +c) вывести список на экран
        +d) вывести минимальное, максимально значения
        +e) вывести сумму чисел на экран
        f) найти наиболее часто встречающееся число, вывести это число и кол-во повторений на экран
        (если чисел несколько с одинаковой частотой повторений, то вывести минимальное из них)*/

import java.util.*;

public class NumbersList {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();


        Random random = new Random();

        for (int i = 0; i < 20 ; i++) {

            list.add(random.nextInt() %100 +1);
        }

        System.out.println(list);

        Collections.sort(list);
        int min = list.get(0);
        System.out.println("Minimum value = " + min);

       Collections.reverse(list);
       int max = list.get(0);
       System.out.println("Maximum value = " + max);

        int sum = 0;
        for (int i = 0; i < 20 ; i++) {

           sum += list.indexOf(i);
        }
        System.out.println("Sum = " + sum);

        //f) найти наиболее часто встречающееся число, вывести это число и кол-во повторений на экран
        //        (если чисел несколько с одинаковой частотой повторений, то вывести минимальное из них)

        HashMap duplicates = new HashMap<>();

        for (int i = 0; i < 20; i++){

            int fr = Collections.frequency(list, list.get(i));
            System.out.println("Number " + list.get(i) + " appears " + fr + " times");

            if(fr>1){
                duplicates.put(list.get(i), fr);
            }
        }

        if (duplicates.isEmpty()){
            System.out.println("No duplicates");
        } else
            System.out.println(duplicates.toString());

    }

}
