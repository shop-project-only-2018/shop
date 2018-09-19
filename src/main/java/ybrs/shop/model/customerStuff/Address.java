package ybrs.shop.model.customerStuff;

import ybrs.shop.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Persons")
public class Address extends BaseEntity {

    // REDO
    @Column(name="Address")
    @NotEmpty
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
