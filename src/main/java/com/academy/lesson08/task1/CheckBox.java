package com.academy.lesson08.task1;

public class CheckBox extends Component {

    protected boolean checked;

    @Override
    public void draw() {

        System.out.println("CheckBox");

    }

    public void click(){}

    public boolean isChecked(){
        return checked;
    }


}
