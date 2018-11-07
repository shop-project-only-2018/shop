package shop.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dtos.order.OrderDto;
import shop.service.order.OrderService;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.List;

import static shop.util.ResponseEntityBuilder.*;

@RestController
@RequestMapping("orders")
public class OrderController {

    private OrderService service;

    @Autowired
    public void setService(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody OrderDto dto) {
        return created(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody OrderDto dto) throws ResourceNotFoundException {
        service.update(dto);
        return ok();
    }

    @GetMapping("/{id}")
    public OrderDto getOne(@PathVariable Integer id) throws ResourceNotFoundException {
        return service.getDtoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return noContent();
    }

    @GetMapping("${paths.all}")
    public List<OrderDto> getAll() {
        return service.getAll();
    }
}
