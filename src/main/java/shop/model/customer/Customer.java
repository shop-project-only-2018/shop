package shop.model.customer;

import shop.model.EntityWithIntId;

import javax.persistence.*;

@Entity
public class Customer implements EntityWithIntId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Person person;

    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Organization organization;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public Integer getId() {
        return customerId;
    }

    @Override
    public void setId(Integer id) {
        this.customerId = id;
    }
}
