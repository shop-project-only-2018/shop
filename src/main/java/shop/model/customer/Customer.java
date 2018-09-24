package shop.model.customer;

import shop.model.BaseEntity;
import shop.model.order.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue
    private int customerId;


//    @OneToOne
//    private Organization organization;
//
//    @OneToOne
//    private Person person;

//    @OneToMany
//    private List<Phone> phoneNumberList;
//
//    @OneToMany
//    private List<Address> addressList;
//
//    @OneToMany
//    private List<Order> orderList;


}
