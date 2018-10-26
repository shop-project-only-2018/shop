package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dtos.product.CategoryDto;
import shop.service.product.CategoryService;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.List;

import static shop.util.ResponseEntityBuilder.*;

@RestController
@RequestMapping("${paths.categories}")
public class CategoryController {

    private CategoryService service;

    @Autowired
    public void setService(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CategoryDto dto) {
        return created(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CategoryDto dto) {
        service.update(dto);
        return ok();
    }

    @GetMapping("/{id}")
    public CategoryDto retrieveCategory(@PathVariable Integer id) throws ResourceNotFoundException {
        return service.getDtoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return noContent();
    }

    @GetMapping("${paths.all}")
    public List<CategoryDto> retrieveAll() {
        return service.retrieveAll();
    }
}
