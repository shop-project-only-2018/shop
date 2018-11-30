package shop.dtos.order;

import shop.dtos.DTO;

public class IdQuantityDto implements DTO {
    private Integer id;
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public IdQuantityDto() {
    }
}
