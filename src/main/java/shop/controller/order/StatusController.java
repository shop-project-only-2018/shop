package shop.controller.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import shop.dtos.order.StatusDto;
import shop.service.order.StatusService;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("status")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody StatusDto statusDto) {
        statusService.save(statusDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<StatusDto> getById(@RequestParam(value = "id")
                                                 @NotNull @Digits(fraction = 0, integer = 10) String statusId) {
        Integer id = Integer.parseInt(statusId);
        StatusDto statusDto = statusService.getById(id);
        if (statusDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<StatusDto> getAll() {
        List<StatusDto> statusDtoList = statusService.getAll();
        return statusDtoList;
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam(value = "id")
                                     @NotNull @Digits(fraction = 0, integer = 10) String statusId) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        Integer id = Integer.parseInt(statusId);
        if (statusService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody StatusDto statusDto) {
        statusService.save(statusDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return new ResponseEntity(HttpStatus.OK);
    }
}
