package shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dtos.pagination.PageDTO;
import shop.dtos.product.BookDto;
import shop.dtos.product.CategoryDto;
import shop.service.product.BookService;
import shop.service.product.CategoryService;

import java.util.List;

@RestController
@RequestMapping("api")
public class IndexRestController {

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

    @GetMapping(value = {"/new-books"})
    public List<BookDto> getNewBooks() {
        List<BookDto> list = bookService.getNewBooks();
        return list;
    }

    @GetMapping(value = {"/bestsellers"})
    public List<BookDto> getBestsellers() {
        List<BookDto> list = bookService.getNewBooks();
        return list;
    }}
