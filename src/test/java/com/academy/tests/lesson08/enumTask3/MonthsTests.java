package com.academy.tests.lesson08.enumTask3;

import com.academy.lesson08.enumTask3.Months;

public class MonthsTests {

    public static void main(String[] args) {
        Months.Month m = Months.Month.MAY;
        m.getNextMonth();
        assert m.getNextMonth() == Months.Month.JUNE;

        Months.Month m1 = Months.Month.DECEMBER;
        m1.getNextMonth();
        assert m.getNextMonth() == Months.Month.JANUARY;

        System.out.println();

        Months.Month m2 = Months.Month.JANUARY;
        m2.getPreviousMonth();
        assert m2.getPreviousMonth() == Months.Month.DECEMBER;

        Months.Month m3 = Months.Month.JULY;
        m3.getPreviousMonth();
        assert m3.getPreviousMonth() == Months.Month.JUNE;

        System.out.println();

        Months.Month m4 = Months.Month.JULY;
        m4.getSeason();
        assert m4.getSeason().equals("Summer");

        Months.Month m5 = Months.Month.DECEMBER;
        m5.getSeason();
        assert m5.getSeason().equals("Winter");


    }
}
