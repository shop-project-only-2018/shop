package shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import shop.dtos.product.CategoryDto;
import shop.service.product.BookService;
import shop.service.product.CategoryService;

import java.util.List;

@Controller
public class IndexController {

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

    @GetMapping(value = {"/", "/index", "/index.html"})
    public String index(Model model) {
        List<CategoryDto> categories = categoryService.getAll();
        model.addAttribute("title", "main.title");
        model.addAttribute("categories", categories);
        return "index";
    }
}
