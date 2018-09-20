package ybrs.shop.model.order;

import ybrs.shop.model.BaseEntity;
import ybrs.shop.model.customer.*;

import javax.persistence.*;

@Entity
@Table(name = "Order_items")
public class OrderItem extends BaseEntity {

    @ManyToOne
    @Column(name="Order")
    private Order order;

    @OneToOne
    private Address address;

    @Column(name="Quantity")
    private int quantity;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
