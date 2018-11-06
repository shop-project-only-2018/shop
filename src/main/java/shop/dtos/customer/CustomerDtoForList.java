package shop.dtos.customer;

import shop.dtos.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerDtoForList implements DTO {

    @NotNull
    private Integer id;

    @NotEmpty
    private String name;

    @NotNull
    private Integer numberOfOrders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public CustomerDtoForList() {}

    public CustomerDtoForList(@NotNull Integer id, @NotEmpty String name, @NotNull Integer numberOfOrders) {
        this.id = id;
        this.name = name;
        this.numberOfOrders = numberOfOrders;
    }}
