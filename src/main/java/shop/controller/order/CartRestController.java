package shop.controller.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dtos.product.BookDto;
import shop.dtos.product.CartBookDto;
import shop.service.product.BookService;
import shop.service.product.CategoryService;
import shop.system.CheckedException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart/")
public class CartRestController {

    @GetMapping
    public List<CartBookDto> getCartBooks() {
        List<CartBookDto> list = new ArrayList<>();
        list.add(new CartBookDto());
                //bookService.getBestsellers();
        return list;
    }

}
