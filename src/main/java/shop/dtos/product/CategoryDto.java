package shop.dtos.product;

import shop.dtos.DTO;

public class CategoryDto implements DTO {
    private Integer categoryId;
    private String name;
    private Integer parentCategoryId;

    public CategoryDto(String name) {
        this.name = name;
    }

    public CategoryDto() {}

    public CategoryDto(Integer categoryId, String name, Integer parentCategoryId) {
        this.categoryId = categoryId;
        this.name = name;
        this.parentCategoryId = parentCategoryId;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}
