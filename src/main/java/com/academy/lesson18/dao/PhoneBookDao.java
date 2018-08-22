package com.academy.lesson18.dao;

import com.academy.lesson18.model.PhoneBookRecord;
import java.util.List;

public interface PhoneBookDao {
    boolean save(PhoneBookRecord record);
	boolean remove(PhoneBookRecord record);
	List<PhoneBookRecord> getAll();
	PhoneBookRecord findByKeys(String phoneNumber, Long operatorId);
}
