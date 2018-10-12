package shop.dtos.customer;

public class OrganizationDto {

    private Integer id;

    private String organizationName;

    public OrganizationDto() {
    }

    public OrganizationDto(Integer id, String organizationName) {
        this.id = id;
        this.organizationName = organizationName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
