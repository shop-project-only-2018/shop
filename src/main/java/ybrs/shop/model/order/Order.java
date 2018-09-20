package ybrs.shop.model.order;

import ybrs.shop.model.BaseEntity;
import ybrs.shop.model.customer.*;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order extends BaseEntity {

    @ManyToOne
    @Column(name="Customer")
    private Customer customer;

    @OneToOne
    private Address address;



}
