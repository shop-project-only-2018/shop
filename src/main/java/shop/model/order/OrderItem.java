package shop.model.order;

import shop.model.BaseEntity;
import shop.model.customer.*;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue
    private int orderItemId;

    @ManyToOne
    private Order order;

    @OneToOne
    private Address address;

    @Column()
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
