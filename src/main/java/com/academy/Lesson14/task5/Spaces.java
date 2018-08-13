package com.academy.Lesson14.task5;

/*5) Создайте лямбда-выражение, которое удаляет все пробелы из заданной строки и возвращает результат.
        Продемонстрируйте работу лямбда-выражения.*/

public class Spaces {

    public static void main(String[] args) {

        String text = "The secret     to happiness is freedom And the secret to freedom is courage.";
        System.out.println("Initial String: " + text);

        RemoveSpaces rs = str -> str.replace(" ", "");

        String result = rs.function(text);
        System.out.println("String without spaces: " + result);
    }
}

interface RemoveSpaces{

    String function(String str);
}