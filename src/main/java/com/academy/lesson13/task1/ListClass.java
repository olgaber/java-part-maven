package com.academy.lesson13.task1;

/*1) Дан массив имен: {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "max}
        +a) Создать список List из элементов массива и вывести на экран
        +b) Добавить 3 новых имени в список (Philip, Joseph, Leon) и вывести весь список на экран
        +c) Удалить из списка все имена: Veronica, Leonid и вывести на экран
        +d) Поменять имя Helen на Elizabet
        +e) Отсортировать имена по алфавиту и вывести на экран
        +f) Отсортировать имена в обратном порядке и вывести имена на экран
        -g) Перевести все первые символы в верхний регистр
        -h) Вывести все имена, начинающиеся на букву A
        +i) Проверить, содержит ли список имя Andrew
        j) Удалить из списка все имена кроме Kate и Helen*/

import java.util.*;

public class ListClass {


    public static void main(String[] args) {

        //Создать список List из элементов массива и вывести на экран

        String[] strArr = {"Peter", "Helen", "Andrew", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "max"};
        List<String> list = new ArrayList<>(Arrays.asList
                ("Peter", "Helen", "Andrew", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "max"));

        System.out.println(list);

        //Добавить 3 новых имени в список (Philip, Joseph, Leon) и вывести весь список на экран

        list.add("Viktor");
        list.add("Yana");
        list.add("James");

        System.out.println(list);

        //Удалить из списка все имена: Veronica, Leonid и вывести на экран

        list.remove("Veronica");
        list.remove("Leonid");

        System.out.println(list);

        //Поменять имя Helen на Elizabet

        list.set(1, "Elizabet");

        System.out.println(list);

        //Отсортировать имена по алфавиту и вывести на экран

        Collections.sort(list);
        System.out.println(list);

        //Отсортировать имена в обратном порядке и вывести имена на экран

        Collections.reverse(list);
        System.out.println(list);

        //Перевести все первые символы в верхний регистр ???

        for (String name : list){
            list.toString().substring(0, 1).toUpperCase();

        }
        System.out.println(list);

        //Вывести все имена, начинающиеся на букву A ???
        for (int i = 0; i < strArr.length; i++){
            if (list.toArray().toString().substring(0, 1).equals("A")) {
                System.out.println(list.get(i));
            }
        }

        //Проверить, содержит ли список имя Andrew

        boolean result = list.contains("Andrew");
        System.out.println(result);

        //Удалить из списка все имена кроме Kate и Helen

        list.removeAll(list);
        list.add("Kate");
        list.add("Helen");
        System.out.println(list);







    }

}

