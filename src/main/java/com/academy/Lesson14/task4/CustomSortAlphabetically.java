package com.academy.Lesson14.task4;

import java.util.Comparator;

public class CustomSortAlphabetically implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {

        if (s1 == s2)
            return 0;
        if (s1 == null)
            return -1;
        if(s2 == null)
            return 1;
        return s1.compareToIgnoreCase(s2);

    }
}
