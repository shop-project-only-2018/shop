package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dtos.product.BasicBookDto;
import shop.dtos.product.FullBookDto;
import shop.service.product.BookService;
import shop.service.product.CategoryService;
import shop.system.CheckedException;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookRestController {

    private BookService bookService;

    private CategoryService categoryService;

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

    @GetMapping(value = {"/new"})
    public List<BasicBookDto> getNewBooks() {
        List<BasicBookDto> list = bookService.getNewBooks();
        return list;
    }

    @GetMapping(value = {"/bestsellers"})
    public List<BasicBookDto> getBestsellers() {
        List<BasicBookDto> list = bookService.getBestsellers();
        return list;
    }
}
