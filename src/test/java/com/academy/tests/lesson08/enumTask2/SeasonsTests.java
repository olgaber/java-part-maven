package com.academy.tests.lesson08.enumTask2;

import com.academy.lesson08.enumTask2.Season;

public class SeasonsTests {

    public static void main(String[] args) {

        Season.Seasons s = Season.Seasons.AUTUMN; //boundary value1 => next
        Season.Seasons s1 = Season.Seasons.WINTER; //boundary value2 => previous
        Season.Seasons s2 = Season.Seasons.SPRING; //middle value

        s.getNext();//winter
        assert s.getNext() == Season.Seasons.WINTER;
        s1.getPrevious();//autumn
        assert s1.getPrevious() == Season.Seasons.AUTUMN;

        s2.getNext();//spring
        assert s2.getNext() == Season.Seasons.SUMMER;

        s2.getPrevious(); //winter
        assert s2.getPrevious() == Season.Seasons.WINTER;
    }
}
