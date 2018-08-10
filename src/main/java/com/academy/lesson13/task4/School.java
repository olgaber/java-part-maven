package com.academy.lesson13.task4;

import java.util.Map;

public interface School {

    void add(Student student);

    Student update(long id, Student student) throws StudentExistenceException;
    Student remove(long id) throws StudentExistenceException;
    Student get(long id);

    Map<Long, Student> getAll();
    Map<Long, Student> getByCourse(int course);
    Map<Long, Student> nextCourceEvent();

}
