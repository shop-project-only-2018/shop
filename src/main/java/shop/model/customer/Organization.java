package shop.model.customer;

import shop.model.AbstractVersionedEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Organization extends AbstractVersionedEntity {

    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    @MapsId
    @OneToOne(mappedBy = "organization")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column
    private String name;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customer);
    }
}
