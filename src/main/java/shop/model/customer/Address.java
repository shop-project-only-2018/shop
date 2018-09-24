package shop.model.customer;

import shop.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table()
public class Address extends BaseEntity {

    @Id
    @GeneratedValue
    private int addressId;

    // REDO
    @Column()
    @NotEmpty
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
