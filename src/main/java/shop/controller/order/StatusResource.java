package shop.controller.order;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import shop.model.order.Status;
import shop.model.product.Category;
import shop.repository.order.StatusRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("status")
public class StatusResource {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusResource(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    @GetMapping("/all")
    public List<Status> retrieveAll() {
        return statusRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Status by id",
            notes = "Also returns a link to retrieve all Statuses with rel - all")
    public Resource<Status> retrieveCategory(@PathVariable Integer id) {
        Optional<Status> status = statusRepository.findById(id);

//        if (!category.isPresent())

        Resource<Status> resource = new Resource<Status>(status.get());

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAll());

        resource.add(linkTo.withRel("all"));

        return resource;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        statusRepository.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createCategory(@RequestBody Status category) {
        Status savedCategory = statusRepository.save(category);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCategory.getStatusId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Status status, @PathVariable Integer id) {

        Optional<Status> categoryOptional = statusRepository.findById(id);

        if (!categoryOptional.isPresent())
            return ResponseEntity.notFound().build();

        status.setStatusId(id);

        statusRepository.save(status);

        return ResponseEntity.noContent().build();
    }
}
