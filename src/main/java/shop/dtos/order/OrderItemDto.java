package shop.dtos.order;

import shop.dtos.DTO;
import shop.model.EntityWithIntegerId;
import shop.model.order.Order;
import shop.model.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;

public class OrderItemDto implements DTO {

    private Integer orderItemId;
    private Integer productId;
    private BigDecimal price;
    private Integer quantity;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderItemDto() {
    }}
