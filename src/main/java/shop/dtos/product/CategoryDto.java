package shop.dtos.product;

import shop.dtos.DTO;

public class CategoryDto implements DTO {
    private int categoryId;
    private String name;

    public CategoryDto(String name) {
        this.name = name;
    }

    public CategoryDto(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public CategoryDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
