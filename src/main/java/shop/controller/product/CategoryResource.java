package shop.controller.product;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import shop.dtos.order.StatusDto;
import shop.model.order.PaymentMethod;
import shop.model.product.Category;
import shop.repository.order.PaymentMethodRepository;
import shop.repository.product.CategoryRepository;
import shop.service.order.StatusService;
import shop.service.product.CategoryService;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("category")
public class CategoryResource {


    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryResource(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retrieve all categories")
    public List<Category> retrieveAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find category by id",
            notes = "Also returns a link to retrieve all Categories with rel - all")
    public Resource<Category> retrieveCategory(@PathVariable Integer id) {
        Optional<Category> category = categoryRepository.findById(id);

//        if (!category.isPresent())
//            throw new StudentNotFoundException("id-" + id);

        Resource<Category> resource = new Resource<Category>(category.get());

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAll());

        resource.add(linkTo.withRel("all"));

        return resource;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete category by id")
    public void delete(@PathVariable Integer id) {
        categoryRepository.deleteById(id);
    }

    @PostMapping
    @ApiOperation(value = "Create new category")
    public ResponseEntity<Object> create(@RequestBody Category category) {
        Category savedCategory = categoryRepository.save(category);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCategory.getCategoryId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update category")
    public ResponseEntity<Object> update(@RequestBody Category category, @PathVariable Integer id) {

        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (!categoryOptional.isPresent())
            return ResponseEntity.notFound().build();

        category.setCategoryId(id);

        categoryRepository.save(category);

        return ResponseEntity.noContent().build();
    }
}
