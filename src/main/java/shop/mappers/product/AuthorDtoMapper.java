package shop.mappers.product;

import org.springframework.stereotype.Component;
import shop.model.product.Author;

@Component
public class AuthorDtoMapper {
    public String map(Author author) {
        return author.getFirstName() + " " + author.getLastName();
    }
}
