package shop.model.customer;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Person {

    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    @MapsId
    @OneToOne(mappedBy = "person")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column
    private String firstName;

    @Column
    private String lastName;

    public Person() {
    }

    public Person(Customer customer, String firstName, String lastName) {
        this.customer = customer;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(customerId, person.customerId) &&
                Objects.equals(customer, person.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customer);
    }


}
