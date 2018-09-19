package ybrs.shop.model.customerStuff;

import ybrs.shop.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Persons")
public class PhoneNumber extends BaseEntity {

    @Column(name="Phone_numbers")
    @NotEmpty
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
