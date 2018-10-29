package shop.dtos.product;

import shop.dtos.DTO;
import shop.model.EntityWithIntId;
import shop.model.product.Category;

import javax.persistence.*;
import java.math.BigDecimal;

public class ProductDto implements DTO {

    private String name;

    private String price;

    private String quantity;

    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ProductDto() {
    }

}
