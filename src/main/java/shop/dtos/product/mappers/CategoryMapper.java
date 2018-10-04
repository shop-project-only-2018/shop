package shop.dtos.product.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import shop.dtos.product.CategoryDto;
import shop.model.product.Category;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );

    @Mapping(source = "name", target = "name")
    Category categoryDtoToCategory(CategoryDto categoryDto);

    @Mapping(source = "name", target = "name")
    CategoryDto categoryToCategoryDto(Category category);

}
