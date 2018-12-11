package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dtos.message.Message;
import shop.dtos.pagination.PageDTO;
import shop.dtos.product.AddingBookDto;
import shop.dtos.product.BasicBookDto;
import shop.dtos.product.FullBookDto;
import shop.service.product.BookSearchService;
import shop.service.product.BookService;
import shop.service.security.RolesService;
import shop.system.CheckedException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
public class BookSearchRestController {

    private BookSearchService bookSearchService;
    private RolesService rolesService;

    @Autowired
    public void setBookSearchService(BookSearchService bookSearchService) {
        this.bookSearchService = bookSearchService;
    }

    @GetMapping(value = {"api/books/search/{word}"})
    public PageDTO<BasicBookDto> search(@PathVariable String word) throws CheckedException {
        return bookSearchService.search(word);
    }

}
