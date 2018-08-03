package com.academy.lesson10.task2;

/*1)
        a) Создать массив типа Component (10 элементов), элементы которого могут любые потомки этого класса
        b) Наполнить массив
        с) В цикле вывести все компоненты на экран
        d) В цикле вывести только Button и его потомков*/


public class Main {
    public static void main(String[] args) {
      
        Component[] components = new Component[10];
        components[0] = new Label();
        components[1] = new Button();
        components[2] = new RoundButton();
        components[3] = new CheckBox();
        components[4] = new Label();
        components[5] = new Button();
        components[6] = new RoundButton();
        components[7] = new CheckBox();
        components[8] = new RoundButton();
        components[9] = new CheckBox();

        for (int i = 0; i <components.length ; i++) {
            components[i].draw();
        }

        Component component = new Component();
        component.draw();

        System.out.println("*********************");

        for (int i = 0; i <components.length ; i++) {
            components[i].draw3D();
        }

        component.draw3D();


    }





}
