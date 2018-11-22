package shop.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dtos.product.ProductDto;
import shop.service.product.BookService;

@RestController
@RequestMapping("books")
public class BookController {

    private BookService service;

    @Autowired
    public void setService(BookService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ProductDto getOne(@PathVariable Integer id) throws Exception {
        return service.getDtoById(id);
    }

//    @GetMapping("${paths.all}")
//    public List<ProductDto> getAll() {
//        return service.getAll();
//    }
}
