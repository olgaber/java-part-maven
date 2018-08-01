package com.academy.tests.lesson08.enumTask4;

import com.academy.lesson08.enumTask4.Date;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateTests {

    @Test
    public static void main(String[] args) {

        Date.DateFormat d = Date.DateFormat.dd_MM_yyyy;
        Date.DateFormat d1 = Date.DateFormat.yyyy_MM_dd;
        Date.DateFormat d2 = Date.DateFormat.mm_dd_yyyy;

        Date date = new Date();
        date.setDay(17);
        date.setMonth(5);
        date.setYear(2000);

        Date date1 = new Date();
        date1.setDay(17);
        date1.setMonth(11);
        date1.setYear(1947);

        Assert.assertEquals(date.getDay(), date1.getDay());

        date.printDate(date, d);
        date.printDate(date, d1);
        date.printDate(date, d2);

    }
}
