package shop.controller.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import shop.dtos.order.StatusDto;
import shop.service.order.StatusService;

import javax.validation.constraints.Digits;
import java.net.URI;

@RestController
@RequestMapping("status")
public class CustomerController {

    private final StatusService statusService;

    @Autowired
    public CustomerController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody StatusDto statusDto) {
        statusService.save(statusDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam(value = "id") @Digits(fraction = 0, integer = 10) String statusId) {
        Integer id = Integer.parseInt(statusId);
        if (id == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        StatusDto statusDto = statusService.getById(id);
        if (statusDto == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StatusDto>(statusDto, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody StatusDto statusDto) {
        statusService.save(statusDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return new ResponseEntity(HttpStatus.OK);
    }
}
