package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dtos.message.Message;
import shop.dtos.order.OrderDto;
import shop.dtos.product.AddingBookDto;
import shop.dtos.product.BasicBookDto;
import shop.dtos.product.FullBookDto;
import shop.service.customer.AuthorizationService;
import shop.service.product.BookService;
import shop.service.product.CategoryService;
import shop.service.security.TokenParserService;
import shop.system.CheckedException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookRestController {

    private BookService bookService;

    private CategoryService categoryService;
    private AuthorizationService authorizationService;

    @Autowired
    public void setTokenParserService(TokenParserService tokenParserService) {
        this.tokenParserService = tokenParserService;
    }

    private TokenParserService tokenParserService;


    @Autowired
    public void setAuthorizationService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }


    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public FullBookDto getById(@PathVariable Integer id) throws CheckedException {
        return bookService.getDtoById(id);
    }

    @GetMapping(value = {"/bestsellers"})
    public List<BasicBookDto> getBestsellers() {
        List<BasicBookDto> list = bookService.getBestsellers();
        return list;
    }

    @PostMapping(value = "add")
    public Message makeOrder(@Valid @RequestBody AddingBookDto addingBookDto,
                             HttpServletRequest request) throws CheckedException {
        bookService.addBook(tokenParserService.getTokenFromHeader(request), addingBookDto);
        return new Message("i18n ADDED");
    }
}
