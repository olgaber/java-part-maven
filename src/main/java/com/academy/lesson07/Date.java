package com.academy.lesson07;

import java.util.Objects;

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

    //methods
    public Date set(Date date){
        Date d = new Date();
        d.day = date.day;
        d.month = date.month;
        d.year = date.year;
        return d;
    }

    public boolean ensureDayCorrect(Date d){

        int number = checkNumberOfDays(d.month, d.year);

        if (number == 28 && d.day > 28) {
            System.out.println("Out of range");
            return false;
        } else if (number == 29 && d.day > 29) {
            System.out.println("Out of range");
            return false;
        } else if (number == 30 && d.day > 30) {
            System.out.println("Out of range");
            return false;
        } else if (number == 31 && d.day > 31) {
            System.out.println("Out of range");
            return false;
        } else
            return true;
    }

    public boolean ensureMonthCorrect(Date d){

        if (d.month > 0 && d.month <= 31){
            return true;
        }
        else{
            System.out.println("Month is out of range");
            return false;
        }
    }

    public boolean ensureYearCorrect(Date d){

        if (d.year > 0 && d.year <= 3000){
            return true;
        }
        else{
            System.out.println("Year is out of range");
            return false;
        }
    }

    public boolean checkLeapYear(int year){

        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
            System.out.println(year + " is a leap year");
            return true;
        }

        return false;
    }

    public int checkNumberOfDays(int month, int year) {

        int daysInMonth;
        boolean leapYear;

        leapYear = checkLeapYear(year);

        if (month == 4 || month == 6 || month == 9 || month == 11)
            daysInMonth = 30;
        else if (month == 2)
            daysInMonth = (leapYear) ? 29 : 28;
        else
            daysInMonth = 31;
        return daysInMonth;
    }

    public int nextDay(Date d){

        if (!checkLeapYear(d.year)){

            if (d.month == 2 && d.day == 28){
                d.day -= 27;
            }
            else if (d.month == 4 && d.month == 6 && d.month == 9 && d.month ==11 && d.day == 30){
                d.day -= 29;
            }
            else if (d.day == 31){
                d.day -= 30;
            }
            else
                d.day++;
        } else {

            if (d.month == 2 && d.day == 29){
                d.day -= 27;
            }
        }

        return  d.day;
    }

    public int nextMonth(Date d){
        if (d.month == 12){
            d.month -= 11;
            return d.month;
        } else {
            System.out.println("Check: " + d.month);
            d.month++;
            return d.month;
        }

    }

    public int nextYear(Date d){

        d.year++;
        return d.year;
    }

    public void printDate(Date d){
        System.out.println(String.format("%d.%d.%d", d.day, d.month, d.year ));
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return year == date.year &&
                month == date.month &&
                day == date.day;
    }

    @Override
    public int hashCode() {

        return Objects.hash(year, month, day);
    }
}
