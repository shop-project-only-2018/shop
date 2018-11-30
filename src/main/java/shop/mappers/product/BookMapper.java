package shop.mappers.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import shop.dtos.product.AddingBookDto;
import shop.dtos.product.BasicBookDto;
import shop.dtos.product.FullBookDto;
import shop.dtos.product.OrderItemBookDto;
import shop.model.product.Book;

@Mapper(uses = {AuthorDtoMapper.class}, componentModel = "spring")
public interface BookMapper {

    @Mappings({
            @Mapping(target = "id", source = "bookId"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "author", source = "author"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "coverId", source = "cover.imageId"),

            @Mapping(target = "quantity", source = "quantity")
    })
    OrderItemBookDto getDto(Book book);

    @Mappings({
            @Mapping(target = "id", source = "bookId"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "author", source = "author"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "coverId", source = "cover.imageId"),

            @Mapping(target = "description", source = "description")
    })
    FullBookDto getFullDto(Book book);

    @Mappings({
            @Mapping(target = "id", source = "bookId"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "author", source = "author"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "coverId", source = "cover.imageId")
    })
    BasicBookDto getBasicDto(Book book);

    @Mappings({
            @Mapping(target = "name", source = "title"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "quantity", source = "quantity")
    })
    Book getEntity(AddingBookDto dto);
}
