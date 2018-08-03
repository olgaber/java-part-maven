package com.academy.lesson10.task1;

/*a) Создать перечисление TimeFormat, которое имеет как минимум два значения:
        - 12 часовой формат
        - 24 часовой формат
        Для константа в перечислении дать осмысленные имена

        b) Создать интерфейс Time, который имеет следующие методы:
        - void setTime(int hours, int minutes, int seconds); // устанавливает значение времени
        - String getTime(TimeFormat timeFormat);		// выдает строковое представление времени в зависимости от переданного формата

        c) Реализовать класс TimeImpl, который реализует интерфейс Time.
        В нем должны быть дополнительные поля
        - часы
        - минута
        - секунда

        и соответственно два метода:
        - void setTime(int hours, int minutes, int seconds);
        - String getTime(TimeFormat timeFormat);

        - продемонстрировать работу класса на различныз значения формата и установленного времени

        d) Реализовать класс TimeImplSeconds, который реализует интерфейс Time.
        В нем должно быть только одно поле:
        - int seconds - кол-во секунд после полуночи

        и соответственно два метода:
        - void setTime(int hours, int minutes, int seconds);
        - String getTime(TimeFormat timeFormat);

        - продемонстрировать работу класса на различныз значения формата и установленного времени

        e) Создать две переменные (в терминах полиморфизма):
        Time timeSimple = new TimeImpl();
        Time timeSeconds = new TimeImplSeconds();

        - продемонстрировать работу двух реализаций класса и убедиться, что оба работают одинаково.*/

public interface Time {
    void setTime(int hours, int minutes, int seconds); // устанавливает значение времени
    String getTime(TimeFormat timeFormat);		// выдает строковое представление
}