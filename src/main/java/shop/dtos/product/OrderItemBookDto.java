package shop.dtos.product;

public class OrderItemBookDto extends BasicBookDto {
    private int quantity = 1;
    private Integer orderItemId;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
