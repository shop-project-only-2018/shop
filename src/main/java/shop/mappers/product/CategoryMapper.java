package shop.mappers.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import shop.dtos.customer.PersonDto;
import shop.dtos.product.CategoryDto;
import shop.model.customer.Person;
import shop.model.product.Category;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

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

}
