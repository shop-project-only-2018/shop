package shop.controller.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dtos.order.OrderDto;
import shop.service.order.OrderService;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.List;

import static shop.util.ResponseEntityBuilder.created;
import static shop.util.ResponseEntityBuilder.ok;

@RestController
@RequestMapping("${paths.order}")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody OrderDto orderDto) {
        return created(orderService.create(orderDto));
    }

    @GetMapping(value = "/{id}")
    public OrderDto getById(@PathVariable Integer id) throws ResourceNotFoundException {
        return orderService.getDtoById(id);
    }

    @GetMapping(value = "/all")
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        orderService.delete(id);
        return ok();
    }

    @PutMapping
    public ResponseEntity update(@RequestBody OrderDto orderDto) {
        orderService.update(orderDto);
        return ok();
    }
}
