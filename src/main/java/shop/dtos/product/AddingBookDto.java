package shop.dtos.product;

import shop.dtos.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AddingBookDto implements DTO {

    @NotNull
    private Integer quantity;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String authorFN;
    @NotEmpty
    private String authorLN;
    @NotNull
    private BigDecimal price;

    private Integer coverId;


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCoverId() {
        return coverId;
    }

    public void setCoverId(Integer coverId) {
        this.coverId = coverId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorFN() {
        return authorFN;
    }

    public void setAuthorFN(String authorFN) {
        this.authorFN = authorFN;
    }

    public String getAuthorLN() {
        return authorLN;
    }

    public void setAuthorLN(String authorLN) {
        this.authorLN = authorLN;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AddingBookDto{" +
                "quantity=" + quantity +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", authorFN='" + authorFN + '\'' +
                ", authorLN='" + authorLN + '\'' +
                ", price=" + price +
                '}';
    }
}
