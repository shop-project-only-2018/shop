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
public class StatusSimpleController {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusSimpleController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @GetMapping("/all")
    public List<Status> retrieveAll() {
        return statusRepository.findAll();
    }

    @GetMapping("/{id}")
    public Resource<Status> retrieveById(@PathVariable Integer id) {
        Optional<Status> status = statusRepository.findById(id);
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
    public ResponseEntity<Object> create(@RequestBody Status entityToSave) {
        Status saved = statusRepository.save(entityToSave);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.getStatusId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Status entityToUpdate, @PathVariable Integer id) {

        Optional<Status> optional = statusRepository.findById(id);

        if (!optional.isPresent())
            return ResponseEntity.notFound().build();

        entityToUpdate.setStatusId(id);

        statusRepository.save(entityToUpdate);

        return ResponseEntity.noContent().build();
    }
}
