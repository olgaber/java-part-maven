package com.academy.lesson10.task2;

class Label extends Component {

    @Override
    public void draw() {
        System.out.println("Draw Label");

    }

    @Override
    public void draw3D(){
        System.out.println("Overridden: Label 3Ddraw method");
    }

}
