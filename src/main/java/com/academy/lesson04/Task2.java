package com.academy.lesson04;

/*a)
        Создать регулярное выражение для поиска несоответствия строки  шаблонy денежного формата:
        - цифры разделенные точкой или запятой
        - разделителя может не быть
        - после разделителя должна быть одна или две цифры
        - в конце должен находится литерал, обозначающий валюту из набора: грн руб $

        Пример:
        0.50грн 	=> true
        0.5грн 		=> true
        12,45руб 	=> true
        15,45 руб 	=> false
        123$ 		=> true
        123.$		=> false
        123.00$		=> true
        a12грн 		=> false
        0.50грн.	=> false
        0.50грн 	=> false

        b)  Написать функцию boolean testCurrencyFormat(String regexFormat);
        - которая тестирует регулярку на заданных выше примерах
        - возвращает  true, если все тесты прошли корректно, false - иначе*/

//\d+[.,]?\d{1,2}

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {

        String reg = "\\d+[.,]?\\d{1,2}[($|(грн)|(руб))]";

        testCurrencyFormat(reg);
    }

    public static void testCurrencyFormat(String regexFormat){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter currency value: ");
        String str = scanner.next();

        boolean result = Pattern.matches(regexFormat, str);

       if(result == true){
           System.out.println("Currency format is correct");
       }
       else{
           System.out.println("Currency format is incorrect");
       }

    }
}
