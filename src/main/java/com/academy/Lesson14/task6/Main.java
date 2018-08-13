package com.academy.Lesson14.task6;



import java.util.*;

public class Main {
    public static void main(String[] args) {

        Subscriber[] subscrArr = new Subscriber[10];
        fillSubscribers(subscrArr);
        System.out.println(Arrays.toString(subscrArr));

        List<Subscriber> subscrList = new ArrayList<>(Arrays.asList(subscrArr));
        System.out.println(subscrList);

        Map<Long, Subscriber> subscrMap = new HashMap<>();
        for (int i = 0; i < subscrArr.length; i++){
            subscrMap.put(subscrArr[i].getId(), subscrArr[i] );
        }
        System.out.println("*************************");
        System.out.println(subscrMap);


        PhoneBook phoneBook = new PhoneBook();
               Subscriber sb = phoneBook.getById(2);
        System.out.println(sb.toString());


       // System.out.println(phoneBook.getById(1));




          }

    private static void fillSubscribers(Subscriber[] subscrArr) {
        String[] names = {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max", "Boris"};
        String[] lastNames = {"Aleksandrov", "Bobrova", "Gusev", "Oleshko", "Zimina", "Ermakova", "Petrov",
                "Abramov", "Kostin", "Maslov"};
        String[] number = {"380501245869", "380671236548", "380971245862","380501245869", "380671236548",
                "380971245862", "380509855869", "380572459652", "380971245862",  "380574128754"};

        long id = 0L;
        for (int i = 0; i < subscrArr.length ; i++) {
            id++;
            int nameIndex = (int) (Math.random() * names.length);
            String name = names[nameIndex];
            String lastName = lastNames[nameIndex];
            int age = (int) (17 + Math.random()*70);
            String phoneNumber = number[i];
            subscrArr[i] = new Subscriber(id, name, lastName, age, phoneNumber);
        }







    }
}
