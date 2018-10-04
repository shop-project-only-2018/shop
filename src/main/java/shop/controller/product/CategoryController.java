package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dtos.product.CategoryDto;
import shop.service.product.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    @ResponseBody
    public CategoryDto add(@RequestParam(name="name") CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        return categoryDto;
    }
}
