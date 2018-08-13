package com.academy.Lesson14.task4;

/*Заданную строку
        +- разбить на слова
        +- отсортировать слова по алфавиту не учитывая регистр первой буквы
        +- отсортировать слова по длине
        - отсортировать слова по последней букве*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringClass {

    public static void main(String[] args) {

        String str = "The secret to happiness is freedom. And the secret to freedom is courage.";

        //разбить на слова
        SplitSentence splitSentence = word -> str.trim().split("\\s");

        String[] words = splitSentence.function(str);

        for (String word: words){
            System.out.println(word);
        }
        //отсортировать слова по алфавиту не учитывая регистр первой буквы

        List<String> sList  = new ArrayList<>(Arrays.asList(words));

        SortAlphabetically sortAlphabetically = stringList -> sList.sort(new CustomSortAlphabetically());
        sortAlphabetically.function(sList);
        System.out.println("Sorted alphabetically: " + sList);

        //отсортировать слова по длине

        SortByLength sortByLength = stringList -> sList.sort(new CustomSortByLength());
        sortByLength.function(sList);
        System.out.println("Sorted by length: " + sList);

        //отсортировать слова по последней букве
        SortByLastLetter sortByLastLetter = stringList -> sList.sort(new CustomSortByLastLetter());
        sortByLastLetter.function(sList);
        System.out.println("Sorted by last letter: " + sList);










    }
}





interface SplitSentence{

    String[] function(String str);
}

interface SortAlphabetically{
    void function(List<String> arr);
}

interface SortByLength{
    void function(List<String> arr);
}

interface SortByLastLetter{
    void function(List<String> arr);
}
