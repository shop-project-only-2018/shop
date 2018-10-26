package shop.dtos.product;

import shop.dtos.DTO;

import java.util.List;

public class CategoryPathDto implements DTO {
    private List<String> categories;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
