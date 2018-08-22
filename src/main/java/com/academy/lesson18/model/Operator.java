package com.academy.lesson18.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Operator {

    private long operatorId;
	private String name;
	private String address;
	private BigDecimal fee; // aбонплата
	private List<String> phoneNumbers; // Список телефонных номеров

    public long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(long operatorId) {
        this.operatorId = operatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "operatorId=" + operatorId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", fee=" + fee +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return operatorId == operator.operatorId &&
                Objects.equals(name, operator.name) &&
                Objects.equals(address, operator.address) &&
                Objects.equals(fee, operator.fee) &&
                Objects.equals(phoneNumbers, operator.phoneNumbers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(operatorId, name, address, fee, phoneNumbers);
    }

    public void addNumber(String number){

        phoneNumbers.add(number);

     }
}
