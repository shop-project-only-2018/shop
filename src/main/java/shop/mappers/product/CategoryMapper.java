package shop.mappers.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import shop.dtos.product.CategoryDto;
import shop.model.product.Category;

@Component
public class CategoryMapper {
    /**
     * The parent category must be retrieved and set by CategoryService
     * @param dto
     * @return
     */
    public Category getEntity(CategoryDto dto) {
        Category result = new Category();
        result.setCategoryId(dto.getCategoryId());
        result.setName(dto.getName());
        result.setParent(null);
        return result;}

    public CategoryDto getDto(Category category)    {
        CategoryDto dto = new CategoryDto();
        dto.setCategoryId(category.getCategoryId());
        dto.setName(category.getName());
        if(category.getParent()!=null){
        dto.setParentCategoryId(category.getParent().getCategoryId());}
        return dto;
    }

    public Category merge(Category recipient, Category source) {
        recipient.setName(source.getName());
        return recipient;
    }

}
