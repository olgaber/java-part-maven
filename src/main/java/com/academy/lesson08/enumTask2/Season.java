package com.academy.lesson08.enumTask2;

public class Season {

    public enum Seasons {
        WINTER,
        SPRING,
        SUMMER,
        AUTUMN;

        public Seasons getNext(){
            Seasons s = values()[(ordinal() + 1)% values().length];

            //add checks
            if (ordinal() == Seasons.values().length){

                System.out.println("The next season is " + Seasons.values()[0]);
            }
            System.out.println("The next season is " + s);
            return  s;
        }

        public Seasons getPrevious(){

            if(ordinal() > 0){

                Seasons s = values()[(ordinal() - 1 )% values().length];
                System.out.println("The previous season is " + s);
                return s;
            }
            else{
                Seasons s1 = values()[(ordinal() + values().length -1)%values().length];
                System.out.println("The previous season is " + s1);
                return s1;
            }
        }

    }
}
