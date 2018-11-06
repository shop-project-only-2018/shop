package shop.controller.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dtos.customer.AddressDto;
import shop.service.customer.AddressService;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.List;

import static shop.util.ResponseEntityBuilder.*;

@RestController
@RequestMapping("addresses")
public class AddressController {

    private AddressService service;

    @Autowired
    public void setService(AddressService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody AddressDto dto) {
        return created(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody AddressDto dto) throws ResourceNotFoundException {
        service.update(dto);
        return ok();
    }

    @GetMapping("/{id}")
    public AddressDto getOne(@PathVariable Integer id) throws ResourceNotFoundException {
        return service.getDtoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return noContent();
    }

    @GetMapping("${paths.all}")
    public List<AddressDto> getAll() {
        return service.getAll();
    }
}
