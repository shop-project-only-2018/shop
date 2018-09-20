package ybrs.shop.model.customer;

import ybrs.shop.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "PhoneNumbers")
public class PhoneNumber extends BaseEntity {

    @Column(name = "Phone_numbers")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
