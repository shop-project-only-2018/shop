package shop.dtos.customer;

import javax.validation.constraints.NotBlank;

public class PersonDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    public PersonDto(@NotBlank String firstName, @NotBlank String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonDto() {
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
}
