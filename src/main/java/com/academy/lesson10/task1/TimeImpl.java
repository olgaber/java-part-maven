package com.academy.lesson10.task1;

public class TimeImpl implements Time {

    int h;
    int m;
    int s;


    @Override
    public void setTime(int hours, int minutes, int seconds) {
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

            System.out.println(str2);
            return str2;

        }
        else if (timeFormat == TimeFormat.HOUR_24) {

            String str3 = checkTime(h, m, s);
            String str4 = str3.substring(0, str3.length()-2);
            System.out.println(str4);

            return str4;

        }
        else
            return "Time is out of range";
    }
    private String checkTime(int h, int m, int s){

        //!!!добавить проверки на am/pm

        if ((int)Math.log10(h)+1 == 1 &&(int)Math.log10(m)+1 == 1 && (int)Math.log10(s)+1 == 1){

            return "0" + h + ":" + "0" + m + ":" + "0" + s + "pm";

        } else  if ((int)Math.log10(h)+1 == 1 &&(int)Math.log10(m)+1 == 1 && (int)Math.log10(s)+1 != 1){
            return "0" + h + ":" + "0" + m + ":" + s + "pm";

        } else  if ((int)Math.log10(h)+1 == 1 &&(int)Math.log10(m)+1 != 1 && (int)Math.log10(s)+1 == 1) {
            return "0" + h + ":" + m + ":" + "0" + s + "pm";

        } else  if ((int)Math.log10(h)+1 != 1 &&(int)Math.log10(m)+1 == 1 && (int)Math.log10(s)+1 != 1){
            return h + ":" + "0" + m + ":" + s + "pm";

        } else  if ((int)Math.log10(h)+1 != 1 &&(int)Math.log10(m)+1 == 1 && (int)Math.log10(s)+1 == 1){
            return h + ":" + "0" + m + ":" + "0" + s + "pm";

        } else  if ((int)Math.log10(h)+1 == 1 &&(int)Math.log10(m)+1 != 1 && (int)Math.log10(s)+1 != 1){
            return "0" + h + ":" + m + ":" + s + "pm";

        } else  if ((int)Math.log10(h)+1 != 1 && (int)Math.log10(m)+ 1 != 1 && (int)Math.log10(s)+ 1 == 1){
            return h + ":" + m + ":" + "0" + s + "pm";
        } else {
            System.out.println("two digits:");
            return h + ":" + m + ":" + s + "pm";
        }

    }

}
