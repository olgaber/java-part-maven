package com.academy.lesson07;

import java.util.Objects;

public class DateTime extends Date{
    private int hour;
    private int minute;
    private int second;

    public DateTime(){

    }

    public DateTime(int year, int month, int day, int hour, int minute, int second) {
        super(year, month, day);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public DateTime(Date date, int hour, int minute, int second) {
        super(date);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DateTime dateTime = (DateTime) o;
        return hour == dateTime.hour &&
                minute == dateTime.minute &&
                second == dateTime.second;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), hour, minute, second);
    }
}
