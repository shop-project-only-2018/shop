package shop.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dtos.order.PaymentMethodDto;
import shop.service.order.PaymentMethodService;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.List;

import static shop.util.ResponseEntityBuilder.*;

@RestController
@RequestMapping("paymentmethods")
public class PaymentMethodController {

    private PaymentMethodService service;

    @Autowired
    public void setService(PaymentMethodService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PaymentMethodDto dto) {
        return created(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PaymentMethodDto dto) throws ResourceNotFoundException {
        service.update(dto);
        return ok();
    }

    @GetMapping("/{id}")
    public PaymentMethodDto getOne(@PathVariable Integer id) throws ResourceNotFoundException {
        return service.getDtoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return noContent();
    }

    @GetMapping("${paths.all}")
    public List<PaymentMethodDto> getAll() {
        return service.getAll();
    }
}
