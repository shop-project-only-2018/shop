package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dtos.pagination.PageDTO;
import shop.dtos.product.BookDto;
import shop.dtos.product.CategoryDto;
import shop.service.product.BookService;
import shop.service.product.CategoryService;
import shop.system.CheckedException;

import java.util.List;
import java.util.Locale;

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
    public BookDto getNewBooks(@PathVariable Integer id) throws CheckedException {
        return bookService.getDtoById(id);
    }

    @GetMapping(value = {"/new"})
    public List<BookDto> getNewBooks() {
        List<BookDto> list = bookService.getNewBooks();
        return list;
    }

    @GetMapping(value = {"/bestsellers"})
    public List<BookDto> getBestsellers() {
        List<BookDto> list = bookService.getBestsellers();
        return list;
    }}
