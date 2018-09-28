package shop.model.customer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Person implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column
    private String firstName;

    @Column
    private String lastName;



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
}
