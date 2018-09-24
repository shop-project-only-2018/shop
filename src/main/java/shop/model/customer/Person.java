package shop.model.customer;

import shop.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table()
public class Person extends BaseEntity {

    @Id
    @GeneratedValue
    private int personId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
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

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
