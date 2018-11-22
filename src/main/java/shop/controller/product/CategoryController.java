package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dtos.product.CategoryDto;
import shop.service.product.CategoryService;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private CategoryService service;

    @Autowired
    public void setService(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public CategoryDto getOne(@PathVariable Integer id) throws Exception {
        return service.getDtoById(id);
    }


    @GetMapping("${paths.all}")
    public List<CategoryDto> getAll() {
        return service.getAll();
    }
}
