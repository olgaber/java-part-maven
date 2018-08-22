package com.academy.lesson18.dao.impl.jdbc;

import com.academy.lesson18.dao.OperatorDao;
import com.academy.lesson18.model.Operator;
import com.academy.lesson18.model.PhoneBookRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperatorDaoImpl extends BaseDao implements OperatorDao {

    private static final String SQL_SELECT_ALL = "SELECT * FROM operator";

    @Override
    public boolean save(Operator operator) {
        return false;
    }

    @Override
    public boolean remove(Operator operator) {
        return false;
    }

    @Override
    public List<Operator> getAll() {
        List<Operator> operators = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Operator operator = new Operator();
                operator.setOperatorId(rs.getLong("abonent_id"));
                operator.setName(rs.getString("name"));
                operator.setAddress(rs.getString("address"));
                operator.setFee(rs.getBigDecimal("fee"));
                operator.setPhoneNumbers(rs.getString("number"));

                operators.add(operator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return operators;
    }

    @Override
    public Operator findById(long id) {
        return null;
    }
}
