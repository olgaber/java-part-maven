package com.academy.lesson18.model;

import com.academy.lesson07.Date;

import java.util.Objects;

public class PhoneBookRecord {

    private String phoneNumber;
	private Long abonentId;
	private Date registeredDate;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getAbonentId() {
        return abonentId;
    }

    public void setAbonentId(Long abonentId) {
        this.abonentId = abonentId;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String toString() {
        return "PhoneBookRecord{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", abonentId=" + abonentId +
                ", registeredDate=" + registeredDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookRecord that = (PhoneBookRecord) o;
        return Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(abonentId, that.abonentId) &&
                Objects.equals(registeredDate, that.registeredDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(phoneNumber, abonentId, registeredDate);
    }


}
