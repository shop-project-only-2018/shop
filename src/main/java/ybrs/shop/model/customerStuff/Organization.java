package ybrs.shop.model.customerStuff;

import ybrs.shop.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Organizations")
public class Organization extends BaseEntity {

    @Column(name="Name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
