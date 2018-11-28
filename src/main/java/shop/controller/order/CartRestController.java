package shop.controller.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dtos.message.Message;
import shop.dtos.product.OrderItemBookDto;
import shop.service.customer.AuthorizationService;
import shop.service.order.OrderService;
import shop.service.security.TokenParserService;
import shop.system.CheckedException;

import javax.servlet.http.HttpServletRequest;
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
    public List<OrderItemBookDto> getCartBooks(HttpServletRequest request) throws CheckedException {
        return orderService.getBooksInCurrentCart(tokenParserService.getTokenFromHeader(request));
    }

    @GetMapping(value = "add/{id}")
    public Message addBook(@PathVariable Integer id, HttpServletRequest request) throws CheckedException {
        orderService.addBookToCurrentCart(tokenParserService.getTokenFromHeader(request), id);
        return new Message();
    }

    @GetMapping(value = "remove/{id}")
    public Message removeBook(@PathVariable Integer id, HttpServletRequest request) throws CheckedException {
        orderService.removeBookFromCurrentCart(tokenParserService.getTokenFromHeader(request), id);
        return new Message();
    }

    @GetMapping("number-of-items")
    public Message getNumberOfItemsInCurrentCart(HttpServletRequest request) throws CheckedException {
        return new Message(
                orderService.getNumberOfItemsInCurrentCart(
                        tokenParserService.getTokenFromHeader(request)));
    }

}