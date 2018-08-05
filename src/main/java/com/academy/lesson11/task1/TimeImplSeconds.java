package com.academy.lesson11.task1;

public class TimeImplSeconds implements Time {

    @Override
    public void setTime(int hours, int minutes, int seconds) {
        System.out.println();

    }

    @Override
    public String getTime(TimeFormat timeFormat) {
        return "00:00:00";
    }
}