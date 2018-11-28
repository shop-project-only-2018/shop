package shop.dtos.product;

public class FullBookDto extends BasicBookDto {
    private String description;

    public FullBookDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
