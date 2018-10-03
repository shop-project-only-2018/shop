package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import shop.DTOs.product.CategoryDto;
import shop.service.product.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping("/category/add")
    @ResponseBody
    public CategoryDto addCategory(@RequestParam(name="name") CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        return categoryDto;
    }
}
