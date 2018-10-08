package shop.dtos.order;

public class OrderDto {
    private String status;
    private Integer id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderDto(String status, Integer id) {
        this.status = status;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderDto(String status) {
        this.status = status;
    }

    public OrderDto() {
    }
}
