package com.academy.lesson15.task;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Subscriber[] subscrArr = new Subscriber[10];
        fillSubscribers(subscrArr);
        System.out.println("Array: " + Arrays.toString(subscrArr));
        System.out.println();

        /*Из массива:
	- исключить дубликаты
	- отсортировать по id,
	- сохранить в список (List)*/

        Collection<Subscriber> collection = Arrays.asList(subscrArr);
        Stream<Subscriber> subscriberStream = collection.stream()
                .distinct()
                .sorted((s1, s2) -> s1.getId().compareTo(s2.getId()));

        System.out.println("Distinct and sorted by id: " );
        subscriberStream.forEach(System.out::println);
        System.out.println();
        List<Subscriber> subscrList = collection.stream().collect(Collectors.toList());

        /*- отсортировать по телефонному номеру
	- отфильтровать по возрасту от 20 до 30
	- перевести первый символ имени и фамилии в верхний регистр
	- перевести все символы кроме первого в нижний регистр
	- вывести на консоль*/

        System.out.println("Sorted by phone number and first letter upper-cased:");

        subscrList.stream()
                .sorted((p1, p2) -> p1.getPhoneNumber().compareTo(p2.getPhoneNumber()))
                .filter(p -> p.getAge() >= 20 && p.getAge()<= 30)
                .map(s -> s.getFirstName().toUpperCase() )
                .map(s -> s.substring(0,1) + s.substring(1, s.length()).toLowerCase())
                .forEach(System.out::println);

        /*Из списка абонентов:
	- исключить дубликаты по телефонном номеру* (не обязательно)
	- отфильтровать по последней цифре номера = 5
	- посчитать средний возраст */

        System.out.println("Filtered and average age:");
                subscrList.stream()
                        .filter(s-> (s.getPhoneNumber().endsWith("5")))
                        .mapToInt(s-> s.getAge())
                        .peek(System.out::println)
                        .average()
                        .stream()
                        .forEach(System.out::println);
    }

    private static void fillSubscribers(Subscriber[] subscrArr){

        String[] names = {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max", "Boris",
                "Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max", "Boris",
                "Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max", "Boris",
                "Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max", "Boris"};
        String[] lastNames = {"Aleksandrov", "Bobrova", "Gusev", "Oleshko", "Zimina", "Ermakova", "Petrov",
                "Abramov", "Kostin", "Maslov",
                "Aleksandrov", "Bobrova", "Gusev", "Oleshko", "Zimina", "Ermakova", "Petrov",
                "Abramov", "Kostin", "Maslov",
                "Aleksandrov", "Bobrova", "Gusev", "Oleshko", "Zimina", "Ermakova", "Petrov",
                "Abramov", "Kostin", "Maslov",
                "Aleksandrov", "Bobrova", "Gusev", "Oleshko", "Zimina", "Ermakova", "Petrov",
                "Abramov", "Kostin", "Maslov"};

        long id = 0L;
        for (int i = 0; i < subscrArr.length; i++) {
            id++;
            int nameIndex = (int) (Math.random() * names.length);
            String name = names[nameIndex];
            String lastName = lastNames[nameIndex];
            int age = (int) (18 + Math.random() * 42);
            String phoneNumber = fillPhoneNumber();
            subscrArr[i] = new Subscriber(id, name, lastName, age, phoneNumber);
        }
    }

    private static String fillPhoneNumber(){

        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String phoneNumber = "999";

            for (int i = 0; i < 8; i++){
                int number = (int) (Math.random()*9);
                phoneNumber = phoneNumber + numbers[number];
            }

           return phoneNumber;
    }
}
