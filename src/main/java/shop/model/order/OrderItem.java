package shop.model.order;

import shop.model.AbstractVersionedEntity;
import shop.model.product.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class OrderItem extends AbstractVersionedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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
}
