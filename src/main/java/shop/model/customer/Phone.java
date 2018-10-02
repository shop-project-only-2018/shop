package shop.model.customer;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phoneId;

    @Column
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String number;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Phone() {
    }

    public Phone(@NotEmpty @Digits(fraction = 0, integer = 10) String number, Customer customer) {
        this.number = number;
        this.customer = customer;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
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
}
