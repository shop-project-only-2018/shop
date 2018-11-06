package shop.dtos.order;

import shop.dtos.DTO;

public class OrderDto implements DTO {
    private Integer id;

    public OrderDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
