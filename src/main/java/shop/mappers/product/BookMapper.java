package shop.mappers.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import shop.dtos.product.BookDto;
import shop.dtos.product.ProductDto;
import shop.mappers.util.CustomerURIMapper;
import shop.model.product.Book;

@Mapper(uses = {AuthorDtoMapper.class}, componentModel = "spring")
public interface BookMapper {

    @Mappings({
            @Mapping(target = "bookId", ignore = true)})
    Book getEntity(ProductDto personDto);

    @Mappings({
            @Mapping(target = "categoryId", ignore = true)
    })
    ProductDto getDto(Book book);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "author", source = "author"),
            @Mapping(target = "quantity", source = "quantity"),
            @Mapping(target = "coverId", source = "cover.imageId")
    })
    BookDto getIndexDto(Book book);

    default Book merge(Book recipient, Book source) {
        recipient.setName(source.getName());
        recipient.setPrice(source.getPrice());
        recipient.setQuantity(source.getQuantity());
        recipient.setCategory(source.getCategory());
        return recipient;
    }

}
