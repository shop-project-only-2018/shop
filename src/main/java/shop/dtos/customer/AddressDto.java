package shop.dtos.customer;

import shop.dtos.DTO;

public class AddressDto implements DTO {
    private String address;

    public AddressDto() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
