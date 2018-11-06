package shop.mappers.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import shop.dtos.product.ProductDto;
import shop.model.product.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(target = "productId", ignore = true)})
    Product getEntity(ProductDto personDto);

    @Mappings({
            @Mapping(target = "categoryId", ignore = true)
    })
    ProductDto getDto(Product category);

    default Product merge(Product recipient, Product source) {
        recipient.setName(source.getName());
        recipient.setPrice(source.getPrice());
        recipient.setQuantity(source.getQuantity());
        recipient.setCategory(source.getCategory());
        return recipient;
    }
}
