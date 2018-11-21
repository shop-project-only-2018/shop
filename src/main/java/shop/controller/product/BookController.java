package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dtos.product.ProductDto;
import shop.service.product.BookService;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.List;

import static shop.util.ResponseEntityBuilder.*;

@RestController
@RequestMapping("books")
public class BookController {

    private BookService service;

    @Autowired
    public void setService(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProductDto dto) {
        return created(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody ProductDto dto) throws ResourceNotFoundException {
        service.update(dto);
        return ok();
    }

    @GetMapping("/{id}")
    public ProductDto getOne(@PathVariable Integer id) throws ResourceNotFoundException {
        return service.getDtoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return noContent();
    }

//    @GetMapping("${paths.all}")
//    public List<ProductDto> getAll() {
//        return service.getAll();
//    }
}
