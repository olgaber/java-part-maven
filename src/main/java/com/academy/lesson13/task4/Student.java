package com.academy.lesson13.task4;

/* a) Напишите класс Student, предоставляющий информацию об студенте:
         конструктор:
         Student(long id, String name, int cource);  // если id отрицательное и course < 1 и > 5 - бросается исключение

         поля:
private long id; 		// уникальный номер ученика
private String name; 	// имя
private int course; 	// курс

        методы:
public long getId();
public String getName();
public int getCourse();

// переводит студента на следующий курс, если 'course'
// становится больше 5 - бросается исключение
// возвращает предыдущее значение курса

public int nextCourse() throws IllegalCourseException;

// Формирует информацию о студенте и возвращает строку вида:
// Student: 1, Peter, "3-th course" (1st, 2nd, 3rd, 4th, 5th)
public String createProfile();*/

import java.util.Objects;

public class Student {

    private long id; 		// уникальный номер ученика
    private String name; 	// имя
    private int course; 	// курс

    public Student(long id, String name, int course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public long getId(){

        return id;
    }

    public String getName(){

        return name;
    }

    public int getCourse(){

        return course;
    }

    public int nextCourse() throws IllegalCourseException{


        return course;
    }

    public String createProfile(){

        String str = "";


        return str;
    }

    void add(Student student) throws StudentExistenceException{

        if (student.getId() == this.id){
            throw new StudentExistenceException();
        }
        else
            add(student);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                course == student.course &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, course);
    }
}
