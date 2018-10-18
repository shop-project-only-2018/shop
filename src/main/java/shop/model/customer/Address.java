package shop.model.customer;

import shop.model.EntityWithIntId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Address extends EntityWithIntId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @Column
    @NotEmpty
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Address(@NotEmpty String address, Customer customer) {
        this.address = address;
        this.customer = customer;
    }

    public Address() {
    }

    @Override
    public Integer getId() {
        return addressId;
    }

    @Override
    public void setId(Integer id) {
        this.addressId = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == address.addressId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId);
    }
}
