package shop.mappers.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import shop.dtos.product.CategoryDto;
import shop.model.product.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId")
    })
    Category getEntity(CategoryDto personDto);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId")
    })
    CategoryDto getDto(Category category);

    default Category merge(Category c1, Category c2) {
        c1.setName(c2.getName());
        return c1;
    }

}
