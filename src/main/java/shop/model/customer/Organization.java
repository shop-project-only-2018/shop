package shop.model.customer;

import shop.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table()
public class Organization extends BaseEntity {

    @Id
    @GeneratedValue
    private int organizationId;

    @Column()
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
