package shop.dtos.customer;

import java.util.List;

public class CustomerDto {
    private Integer id;

    private OrganizationDto organizationDto;

    private PersonDto personDto;

    private List<String> phoneNumberList;
    private List<String> addressList;

    public CustomerDto() {
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

    public CustomerDto(Integer id, OrganizationDto organizationDto, PersonDto personDto, List<String> phoneNumberList, List<String> addressList) {
        this.id = id;
        this.organizationDto = organizationDto;
        this.personDto = personDto;
        this.phoneNumberList = phoneNumberList;
        this.addressList = addressList;
    }
}
