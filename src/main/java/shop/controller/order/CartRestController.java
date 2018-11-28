package shop.controller.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dtos.message.Message;
import shop.dtos.product.CartBookDto;
import shop.dtos.security.UsernameTokenDTO;
import shop.service.customer.AuthorizationService;
import shop.service.order.OrderService;
import shop.service.security.TokenParserService;
import shop.system.CheckedException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart/")
public class CartRestController {

    private OrderService orderService;
    private AuthorizationService authorizationService;
    private TokenParserService tokenParserService;


    @Autowired
    public void setAuthorizationService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setTokenParserService(TokenParserService tokenParserService) {
        this.tokenParserService = tokenParserService;
    }

    @GetMapping
    public List<CartBookDto> getCartBooks() {
        List<CartBookDto> list = new ArrayList<>();
        list.add(new CartBookDto());
        //bookService.getBestsellers();
        return list;
    }

    @PostMapping(value = "add/{id}") // TODO: REMOVE RequestBody
    public Message addBook(@RequestBody UsernameTokenDTO usernameTokenDTO,
                           @PathVariable Integer id,
                           HttpServletRequest request) throws CheckedException {
        usernameTokenDTO.setToken(tokenParserService.getTokenFromHeader(request));
        orderService.addBookToCurrentCart(usernameTokenDTO, id);
        return new Message();
    }

    @GetMapping("number-of-items")
    public Message getNummmmmmmm(@RequestParam @NotNull Integer id,
                                 //  @RequestParam @NotNull String username,
                                 HttpServletRequest request) throws CheckedException {
//        orderService.addBookToCurrentCart(usernameTokenDTO, id);
        return new Message();
    }

}