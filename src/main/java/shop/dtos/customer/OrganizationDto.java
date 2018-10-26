package shop.dtos.customer;

import shop.dtos.DTO;

import javax.validation.constraints.NotBlank;

public class OrganizationDto implements DTO {

    @NotBlank
    private String name;

    public OrganizationDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
