package shop.controller.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dtos.customer.PhoneDto;
import shop.service.customer.PhoneService;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.List;

import static shop.util.ResponseEntityBuilder.*;

@RestController
@RequestMapping("phones")
public class PhoneController {

    private PhoneService service;

    @Autowired
    public void setService(PhoneService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PhoneDto dto) {
        return created(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PhoneDto dto) throws ResourceNotFoundException {
        service.update(dto);
        return ok();
    }

    @GetMapping("/{id}")
    public PhoneDto getOne(@PathVariable Integer id) throws ResourceNotFoundException {
        return service.getDtoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return noContent();
    }

    @GetMapping("${paths.all}")
    public List<PhoneDto> getAll() {
        return service.getAll();
    }
}
