package com.academy.lesson07;

public class DemoMain {
    public static void main(String[] args) {
        Date date1 = new Date(2017, 12, 31);
        Date date2 = new Date(2017, 2, 23);
        Date date3 = new Date(2018, 5, 23);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date1.equals(date2));
        System.out.println(date1.equals(date3));

        //get() methods
        System.out.println("Day = " + date1.getDay());
        System.out.println("Month = " + date1.getMonth());
        System.out.println("Year = " + date1.getYear());

        //next() methods
        int day = date1.nextDay(date1);
        System.out.println(day);
        int month = date1.nextMonth(date1);
        System.out.println(month);
        int year = date1.nextYear(date1);
        System.out.println(year);

        //print
        date1.printDate(date2);

        DateTime dateTime1 = new DateTime(1954,2,15,7,44,12);
        DateTime dateTime2 = new DateTime(2009,7,14,5,38,31);
        DateTime dateTime3 = new DateTime(1954,2,15,7,44,12);

        System.out.println(dateTime1);
        System.out.println(dateTime2);
        System.out.println(dateTime3);
        System.out.println(dateTime1.equals(dateTime2));
        System.out.println(dateTime1.equals(dateTime3));



    }
}
