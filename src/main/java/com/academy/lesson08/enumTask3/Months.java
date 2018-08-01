package com.academy.lesson08.enumTask3;

public class Months{

    public enum Month{

        JANUARY(31, "Январь"),
        FEBRUARY(28, "Февраль"),
        MARCH(31, "Март"),
        APRIL(30, "Апрель"),
        MAY(31, "Май"),
        JUNE(30, "Июнь"),
        JULY(31, "Июль"),
        AUGUST(31, "Август"),
        SEPTEMBER(30, "Сентябрь"),
        OCTOBER(31, "Октябрь"),
        NOVEMBER(30, "Ноябрь"),
        DECEMBER(31, "Декабрь");

        private int daysQty;
        private String rusTranslation;

        Month(int Qty, String ru) {
            this.daysQty = Qty;
            this.rusTranslation = ru;
        }

        public int getYearsQty() {
            return daysQty;
        }

        public String getRusTranslation() {
            return rusTranslation;
        }

        public void setRusTranslation(String rusTranslation) {
            this.rusTranslation = rusTranslation;
        }

        public void setYearsQty(int yearsQty) {
            this.daysQty = yearsQty;
        }

        public Month getNextMonth(){

            if (ordinal() > 0 && ordinal() != 11){
                Month m = values()[(ordinal() + 1) % values().length];
                System.out.println("The next month is " + m);
                return m;
            }
            else {
                Month m = values()[(ordinal() + values().length - 11) % values().length];
                System.out.println("The next month is " + m);
                return m;
            }
        }
        public Month getPreviousMonth(){

            if (ordinal() > 0){
                Month m = values()[(ordinal() - 1) % values().length];
                System.out.println("The previous month is " + m);
                return m;
            }
            else {
                Month m = values()[(ordinal() + values().length - 1) % values().length];
                System.out.println("The previous month is " + m);
                return m;
            }
        }

        public String getSeason(){

            if (ordinal() >= 0 && ordinal() <= 1 || ordinal() == 11){
                System.out.println("The season is Winter");
                return "Winter";
            } else if (ordinal() >= 2 && ordinal() <= 4){
                System.out.println("The season is Spring");
                return "Spring";
            }
            else if (ordinal() >= 5 && ordinal() <= 7) {
                System.out.println("The season is Summer");
                return "Summer";
            }
            else {
                System.out.println("The season is Autumn");
                return "Autumn";
            }

        }

        @Override
        public String toString() {

            return name() +" (has " + daysQty + " days. In Russian: " + rusTranslation + ")";

        }




    }

}
