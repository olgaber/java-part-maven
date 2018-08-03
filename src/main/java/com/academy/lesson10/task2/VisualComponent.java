package com.academy.lesson10.task2;

public interface VisualComponent {

    void draw();

    default void draw3D() {

        System.out.println("Default draw3D method");

    }
}
