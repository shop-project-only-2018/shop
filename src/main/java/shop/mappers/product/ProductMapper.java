package shop.mappers.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import shop.dtos.product.ProductDto;
import shop.model.product.Book;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(target = "productId", ignore = true)})
    Book getEntity(ProductDto personDto);

    @Mappings({
            @Mapping(target = "categoryId", ignore = true)
    })
    ProductDto getDto(Book category);

    default Book merge(Book recipient, Book source) {
        recipient.setName(source.getName());
        recipient.setPrice(source.getPrice());
        recipient.setQuantity(source.getQuantity());
        recipient.setCategory(source.getCategory());
        return recipient;
    }
}
