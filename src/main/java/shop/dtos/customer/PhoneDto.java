package shop.dtos.customer;

import shop.dtos.DTO;

public class PhoneDto implements DTO {
    private Integer phoneId;
    private String number;

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }}
