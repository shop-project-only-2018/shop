package ybrs.shop.model.customerStuff;

import ybrs.shop.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customers")
public class Customer extends BaseEntity {

    @OneToOne
    @Column(name="Organization")
    private Organization organization;

    @OneToOne
    @Column(name="Person")
    private Person person;

    @OneToMany
    private List<PhoneNumber> phoneNumbers;

    @OneToMany
    private List<Address> addresses;


    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
