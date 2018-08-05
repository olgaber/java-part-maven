package com.academy.lesson11.task1;

public class TimeImpl implements Time {

    int h;
    int m;
    int s;

    public TimeImpl() {
    }

    public TimeImpl(int h, int m, int s) throws OutOfRange {

        if((h > 24 || h < 0) || (m > 60 || m < 0) || (s > 60 || s < 0)){
            throw new OutOfRange();
        }
        this.h = h;
        this.m = m;
        this.s = s;
    }

    @Override
    public void setTime(int hours, int minutes, int seconds) throws OutOfRange {

        if((hours > 24 || h < 0) || (minutes > 60 || minutes < 0) || (seconds > 60 || seconds < 0)){
            throw new OutOfRange();
        }

        this.h = hours;
        this.m = minutes;
        this.s = seconds;
    }


    @Override
    public String getTime(TimeFormat timeFormat) {

        if (timeFormat == TimeFormat.HOUR_12 && (h >= 1 && h <= 12)){

            String str1 = checkTime(h, m, s);
            System.out.println(str1);

            return str1;
        }
        else if (timeFormat == TimeFormat.HOUR_12 && (h > 12 && h <= 23)){

            h -= 12;

            String str2 = checkTime(h, m, s);


            return str2;

        }
        else if (timeFormat == TimeFormat.HOUR_24) {

            String str3 = checkTime(h, m, s);
            String str4 = str3.substring(0, str3.length()-2);

            return str4;

        }
        else
            return "Time is out of range";
    }
    private String checkTime(int h, int m, int s){

        return String.format("%02d:%02d:%02d", h, m, s) + "pm";

    }

}
