package shop.dtos.customer;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CustomerDto {

    @NotNull
    private Integer id;

    //    @NotNull
    private OrganizationDto organizationDto;

    //    @NotNull
    private PersonDto personDto;

    //    @NotEmpty
    private List<String> phoneNumberList;

    //    @NotEmpty
    private List<String> addressList;

    public CustomerDto() {
    }

    @AssertTrue
    public boolean check() {
        if (personDto == null & organizationDto == null) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrganizationDto getOrganizationDto() {
        return organizationDto;
    }

    public void setOrganizationDto(OrganizationDto organizationDto) {
        this.organizationDto = organizationDto;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public List<String> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(List<String> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }
}
