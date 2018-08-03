package com.academy.lesson10.task2;

/*Добавить в иерархию классов Component новый интерфейс VisualComponent
        унаследовать класс Component от VisualComponent
        (Component implements VisualComponent)

        Интерфейс VisualComponent должен иметь один метод:
        - void draw();

        -продемонстрировать работу метода draw() у всех компонентов

        3) Добавить новый метод по умолчанию в VisualComponent
        - void draw3D(); //

        унаследовать класс Component от VisualComponent
        - перекрыть метод draw3D у Label
        - продемонстрировать работу метода draw3D(); во всех компонентах*/

import com.academy.lesson10.task1.VisualComponent;

public class Component implements VisualComponent {
    protected int xPosition;
    protected int yPosition;
    protected int width;
    protected int height;
    protected String text;

     @Override
    public void draw() {
        System.out.println("Draw Component");
    }
}

