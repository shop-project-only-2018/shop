package shop.dtos.product;

import shop.dtos.DTO;
import shop.model.EntityWithIntegerId;
import shop.model.product.Category;

import javax.persistence.*;
import java.math.BigDecimal;

public class BookDto implements DTO {

    private String name;
    private String author;
    private String description;
    private BigDecimal price;
    private int quantity;
    private Integer coverId;

    public Integer getCoverId() {
        return coverId;
    }

    public void setCoverId(Integer coverId) {
        this.coverId = coverId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BookDto() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
