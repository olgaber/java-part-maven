package com.academy.lesson08.task1;

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

        for (int i = 0; i <components.length ; i++) {

            if (components[i] instanceof Button || components[i] instanceof RoundButton || components[i] instanceof CheckBox){
                System.out.println(i + " Component is a button or child of a button");

            }

        }
    }





}
