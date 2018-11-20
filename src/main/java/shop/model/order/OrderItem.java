package shop.model.order;

import shop.model.EntityWithIntegerId;
import shop.model.product.Book;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderItem implements EntityWithIntegerId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Book product;

    @Column
    private BigDecimal price;

    @Column
    private int quantity;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getProduct() {
        return product;
    }

    public void setProduct(Book product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Integer getId() {
        return orderItemId;
    }

    @Override
    public void setId(Integer id) {
        this.orderItemId = id;
    }
}
