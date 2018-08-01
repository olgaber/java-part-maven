package com.academy.tests.lesson08.enumTask1;

/*1)  Перечисление для представления дней недели
        Реализовать перечисление "День недели"
        В перечислении "День недели" добавить функции получения дня "позавчера" и "послезавтра".
        Протестировать перечисление в функции main() тестового класса.*/


import com.academy.lesson08.enumTask1.Week;

public class WeekTests {

    public static void main(String[] args) {

        Week.DayofWeek current = Week.DayofWeek.WEDNESDAY;
        current.getDayBeforeYesterday(); //monday
        assert current.getDayBeforeYesterday() == Week.DayofWeek.MONDAY;


        Week.DayofWeek current1 = Week.DayofWeek.MONDAY;
        current1.getDayBeforeYesterday(); //SATURDAY
        assert current1.getDayBeforeYesterday() == Week.DayofWeek.SATURDAY;


        Week.DayofWeek current2 = Week.DayofWeek.SUNDAY;
        current2.getDayBeforeYesterday();//Friday
        assert current2.getDayBeforeYesterday() == Week.DayofWeek.FRIDAY;


        System.out.println();

        Week.DayofWeek current3 = Week.DayofWeek.FRIDAY;
        current3.getDayAfterTomorrow();
        assert current3.getDayAfterTomorrow() == Week.DayofWeek.SUNDAY;

        Week.DayofWeek current4 = Week.DayofWeek.SATURDAY;
        current4.getDayAfterTomorrow();
        assert current4.getDayAfterTomorrow() == Week.DayofWeek.MONDAY;


        Week.DayofWeek current5 = Week.DayofWeek.WEDNESDAY;
        current5.getDayAfterTomorrow();
        assert current5.getDayAfterTomorrow() == Week.DayofWeek.FRIDAY;

    }

}
