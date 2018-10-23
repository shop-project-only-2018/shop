package shop.dtos.customer;

import javax.validation.constraints.NotBlank;

public class OrganizationDto {
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
