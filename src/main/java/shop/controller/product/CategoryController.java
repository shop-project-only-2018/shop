package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import shop.dtos.order.StatusDto;
import shop.service.order.StatusService;
import shop.service.product.CategoryService;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
//
//    @PostMapping
//    public ResponseEntity add(@RequestBody CategoryDto categoryDto) {
//        categoryService.save(categoryDto);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
//        return new ResponseEntity(HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<StatusDto> getById(@RequestParam(value = "id")
//                                                 @NotNull @Digits(fraction = 0, integer = 10) String statusId) {
//        Integer id = Integer.parseInt(statusId);
//        StatusDto statusDto = categoryService.getById(id);
//        if (statusDto == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(statusDto, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/all")
//    public List<StatusDto> getAll() {
//        List<StatusDto> statusDtoList = categoryService.getAll();
//        return statusDtoList;
//    }
//
//    @DeleteMapping
//    public ResponseEntity delete(@RequestParam(value = "id")
//                                     @NotNull @Digits(fraction = 0, integer = 10) String statusId) {
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
//        Integer id = Integer.parseInt(statusId);
//        if (categoryService.delete(id)) {
//            return new ResponseEntity(HttpStatus.OK);
//        } else {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity update(@RequestBody StatusDto statusDto) {
//        categoryService.save(statusDto);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
