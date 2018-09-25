package shop.model.order;

import shop.model.BaseEntity;
import shop.model.customer.*;

import javax.persistence.*;

@Entity
@Table()
public class Order extends BaseEntity {

    @Id
    @GeneratedValue
    private int orderId;

    @ManyToOne
    @JoinColumn(name="order_customer_customer_id_fk")
    private Customer customer;

//    @OneToOne
//    private Address address;



}
