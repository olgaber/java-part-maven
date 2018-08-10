package com.academy.lesson13.task4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Long, Student> map = new HashMap<>();

        map.put(31L, new Student(31L, "Vitaly", 2));
        map.put(45L, new Student (45L, "Igor", 4));
        map.put(17L, new Student (17L, "Maria", 1));
        map.put(214L, new Student (214L, "Artem", 3));
        map.put(844L, new Student (3L, "Hanna", 5));
        map.put(348L, new Student (348L, "Helen", 4));
        map.put(11L, new Student (11L, "Pablo", 4));
        map.put(26L, new Student (26L, "Irina", 5));
        map.put(17L, new Student (17L, "Nataly", 3));
        map.put(72L, new Student (72L, "Igor", 2));

        for (Map.Entry<Long, Student> entry: map.entrySet()) {
            System.out.println("key =" + entry.getKey() );
            System.out.println("value =" + entry.getValue() );
        }


        //getId() tests

        //getName() tests

        //getCourse() tests

        //nextCourse() tests

        //createProfile() tests

        //add(Student student) tests




    }
}
