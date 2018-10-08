package shop.dtos.customer;

public class CustomerDto {
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerDto(Integer id) {
        this.id = id;
    }

    public CustomerDto() {
    }
}
