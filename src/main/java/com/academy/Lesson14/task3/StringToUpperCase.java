package com.academy.Lesson14.task3;

/*Создайте лямбда-выражение, которое переводит строку в верхний режим.
        Перевести строку в верхний регистр с помощью лямбда-выражения.
        Перевести строку в верхний регистр с помощью ссылки на метод.*/


import java.util.function.Function;

public class StringToUpperCase {

    public static void main(String[] args) {

        //Перевести строку в верхний регистр с помощью лямбда-выражения.
        SetToUpperCase setUp = str ->  str.toUpperCase();
        System.out.println(setUp.function("please make my letters upper cased"));

        //Перевести строку в верхний регистр с помощью ссылки на метод
        System.out.println("********************");
        System.out.println(actionWithString("please make my letters upper cased", String :: toUpperCase));
    }

    private static String actionWithString(String str, Function<String, String> action) {
        return action.apply(str);
    }
}

interface SetToUpperCase{

    String function(String str);
}


