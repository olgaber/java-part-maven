package com.academy.lesson08.enumTask1;

public class Week {

    public enum DayofWeek{

        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THIRSDAY,
        FRIDAY,
        SATURDAY;

        public DayofWeek getDayBeforeYesterday(){

            //WEDNESDAY => MONDAY
            if (ordinal() > 0 && ordinal() != 1 && ordinal() != 0){
                DayofWeek d = values()[(ordinal() - 2)%values().length];
                System.out.println("The day before yesterday is " + d);

                return d;
            }
            //MONDAY => SATURDAY
            else if (ordinal() == 1){
                DayofWeek d1 = values()[(ordinal() + values().length - 1)%values().length];
                System.out.println("The day before yesterday is " + d1);

                return d1;
            }
            //SUNDAY => FRIDAY
            else{
                DayofWeek d2 = values()[(ordinal() + values().length - 2) % values().length];
                System.out.println("The day before yesterday is " + d2);

                return d2;
            }
        }

        public DayofWeek getDayAfterTomorrow(){

            if (ordinal() > 0 && ordinal() != 5 && ordinal() != 6){

                DayofWeek d = values()[(ordinal() + 2)%values().length];
                System.out.println("The day after tomorrow is " + d);
                return d;
            } else {

                DayofWeek d1 = values()[(ordinal() + values().length - 5)%values().length];
                System.out.println("The day before yesterday is " + d1);

                return d1;
            }

        }
    }


}

