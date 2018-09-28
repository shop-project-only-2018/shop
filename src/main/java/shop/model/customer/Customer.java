package shop.model.customer;

import shop.model.order.Order;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_customer_id_seq")
    private Integer customerId;


    //    @OneToMany
//    @JoinColumn(table="phone")
//    private List<Phone> phones;
//
//    @OneToMany
//    @JoinColumn(table="address")
//    private List<Address> addresses;
//
//    @OneToMany
//    @JoinColumn(table="order")
//    private List<Order> orders;

}
