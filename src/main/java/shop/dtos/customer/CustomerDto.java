package shop.dtos.customer;

import shop.dtos.DTO;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CustomerDto implements DTO {

    private Integer customerId;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private List<PhoneDto> phoneNumberList;

    private List<AddressDto> addressList;

    public CustomerDto() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PhoneDto> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(List<PhoneDto> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    public List<AddressDto> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressDto> addressList) {
        this.addressList = addressList;
    }
}
