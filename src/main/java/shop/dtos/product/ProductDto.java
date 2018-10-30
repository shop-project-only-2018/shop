package shop.dtos.product;

import shop.dtos.DTO;

import java.math.BigDecimal;

public class ProductDto implements DTO {

    private Integer productId;
    private Integer categoryId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public ProductDto() {}

    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public Integer getProductId() {
        return productId;
    }    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
