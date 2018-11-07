package shop.dtos.customer;

import shop.dtos.DTO;

public class AddressDto implements DTO {
    private Integer addressId;
    private String address;

    public AddressDto() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
