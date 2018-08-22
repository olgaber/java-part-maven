package com.academy.lesson18.dao.impl.jdbc;

import com.academy.lesson18.dao.PhoneBookDao;
import com.academy.lesson18.model.PhoneBookRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookDaoImpl extends BaseDao implements PhoneBookDao{

    private static final String SQL_SELECT_ALL = "SELECT * FROM phone_book";

    @Override
    public boolean save(PhoneBookRecord record) {
        return false;
    }

    @Override
    public boolean remove(PhoneBookRecord record) {
        return false;
    }

    @Override
    public List<PhoneBookRecord> getAll() {
        List<PhoneBookRecord> phoneBookRecords = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PhoneBookRecord phoneBookRecord = new PhoneBookRecord();
                phoneBookRecord.setPhoneNumber(rs.getString("phone number"));
                phoneBookRecord.setAbonentId(rs.getLong("abonent id"));
                phoneBookRecord.setRegisteredDate(rs.getDate("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phoneBookRecords;
    }

    @Override
    public PhoneBookRecord findByKeys(String phoneNumber, Long operatorId) {
        return null;
    }
}
