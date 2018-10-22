package shop.dtos.customer;

import javax.validation.constraints.NotBlank;

public class OrganizationDto {
    @NotBlank
    private String organizationName;

    public OrganizationDto() {
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
