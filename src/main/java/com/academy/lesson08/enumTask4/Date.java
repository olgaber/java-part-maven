package com.academy.lesson08.enumTask4;

public class Date {

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date(){
        this.day = 1;
        this.month = 1;
        this.year = 1970;
    }
    public Date(Date date){
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {//проверить правильность полей
        if (year < 0 || year > 3000){
            System.out.println("Year is out of range");
        } else
            this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {//проверить правильность полей
        if (month < 0 || month > 12) {
            System.out.println("Month is out of range");
        } else
            this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {//проверить правильность полей
        if (day < 0 || day > 31) {
            System.out.println("Day is out of range");
        }
        this.day = day;
    }

    public enum DateFormat{

        dd_MM_yyyy,
        yyyy_MM_dd,
        mm_dd_yyyy

    }

    public void printDate(Date date, DateFormat dateFormat){
        switch(dateFormat){
            case dd_MM_yyyy:
                System.out.println(String.format("%d.%d.%d", date.getDay(), date.getMonth(), date.getYear()));
                break;
            case mm_dd_yyyy:
                System.out.println(String.format("%d.%d.%d", date.getMonth(), date.getDay(), date.getYear()));
                break;
            case yyyy_MM_dd:
                System.out.println(String.format("%d.%d.%d", date.getYear(), date.getMonth(), date.getDay()));
                break;
            default:
                    System.out.println("Default");

        }





    }

}
