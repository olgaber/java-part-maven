package com.academy.lesson18.dao;

import com.academy.lesson18.model.Operator;
import java.util.List;

public interface OperatorDao {
    boolean save(Operator operator);
    boolean remove(Operator operator);
    List<Operator> getAll();
    Operator findById(long id);
}
