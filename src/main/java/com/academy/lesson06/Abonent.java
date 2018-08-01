package com.academy.lesson06;

/*
Реализовать класс Abonent, который имеет поля:
        long id; // необязательное поле, по умолчанию -1
        String firstName;
        String lastName;
        int age;
        char gender; // 'm' - male, 'f' - female

        Все поля должны быть помечены модификатором private
		- реализовать доступ к полям через методы set и get
                - реализовать возможность создания класса через два конструктора:
                1-> все поля, без обязательного поля "id"
                2-> полный конструктор со всем полями

                - реализовать метод void print(); вывода информации абонента в отформатированном виде
                - реализовать метод boolean isEquals(Abonent abonent); // вернут true, если id обоих объектов равны и не равны -1, false - в остальных случаях
                - протестировать метод isEquals
*/

public class Abonent {

    private long id = -1L;
    private String firstName;
    private String lastName;
    private int age;
    private char gender;//m,f

    public Abonent(String firstName, String lastName, int age, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Abonent(long id, String firstName, String lastName, int age, char gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public static void main(String[] args) {
        isEqualTest();

    }

    public void print(){

        System.out.println(String.format("Id: %d", id));
        System.out.println(String.format("First Name: %s", firstName));
        System.out.println(String.format("Last Name: %s", lastName));
        System.out.println(String.format("Age: %s", age));
        System.out.println(String.format("Gender: %s", gender));
        System.out.println();
    }

    public boolean isEqual(Abonent abonent){


        if(this.id == abonent.id && this.id != -1){
            System.out.println("Ids are equal");
            return true;
        } else {
            System.out.println("Ids are not equal");
            return false;
        }
    }

    public static void isEqualTest(){
        Abonent ab1 = new Abonent("Jane", "Doe", 21, 'f');
        Abonent ab2 = new Abonent(10, "James", "Parker", 44, 'm');
        Abonent ab3 = new Abonent(10, "Mary", "Poppins", 30, 'f');

        ab1.print();
        ab2.print();

        assert ab2.isEqual(ab1);
        System.out.println("Ids of ab1 and ab2 are NOT equal");

        System.out.println();

        ab2.print();
        ab3.print();

        assert ab3.isEqual(ab2);
        System.out.println("Ids of ab2 and ab3 are equal");
    }

}


