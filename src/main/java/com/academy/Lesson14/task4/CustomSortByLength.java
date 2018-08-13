package com.academy.Lesson14.task4;

import java.util.Comparator;

public class CustomSortByLength implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {

        if (s1.length() == s2.length())
            return 0;
        if (s1.length() > s2.length())
            return -1;
        if(s2.length() > s1.length())
            return 1;
        return (s1.compareTo(s2));

    }

}
