package com.academy.lesson10.task2;

public class CheckBox extends Component {

    protected boolean checked;

    @Override
    public void draw() {

        System.out.println("Draw CheckBox");

    }

    public void click(){}

    public boolean isChecked(){
        return checked;
    }


}
