package shop.controller.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.dtos.message.Message;
import shop.dtos.product.OrderItemBookDto;
import shop.service.customer.AuthorizationService;
import shop.service.order.OrderService;
import shop.service.security.TokenParserService;
import shop.system.CheckedException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart/items/")
public class OrderItemRestController {

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

    //TODO: OrderItems to the DB
    @PostMapping(value = "set-quantity")
    public Message makeOrder(@RequestBody Map<Integer, Integer> items,
                             HttpServletRequest request) throws CheckedException {
        orderService.setItemsQuantity(tokenParserService.getTokenFromHeader(request), items);
        return new Message("i18n items");
    }

}