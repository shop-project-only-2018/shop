package shop.model.customer;

import shop.model.EntityWithIntegerId;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Entity
public class Phone implements EntityWithIntegerId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phoneId;

    @Column
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String number;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Phone() {}

    public Phone(@NotEmpty @Digits(fraction = 0, integer = 10) String number, Customer customer) {
        this.number = number;
        this.customer = customer;
    }

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
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Integer getId() {
        return phoneId;
    }

    @Override
    public void setId(Integer id) {
        this.phoneId = id;
    }
}
