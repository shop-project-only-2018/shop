package shop.controller.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import shop.model.order.PaymentMethod;
import shop.repository.order.PaymentMethodRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("paymentmethod")
public class PaymentMethodResource {

    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodResource(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @GetMapping("/all")
    public List<PaymentMethod> retrieveAll() {
        return paymentMethodRepository.findAll();
    }

    @GetMapping("/{id}")
    public Resource<PaymentMethod> getById(@PathVariable Integer id) {
        Optional<PaymentMethod> student = paymentMethodRepository.findById(id);
        Resource<PaymentMethod> resource = new Resource<PaymentMethod>(student.get());

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAll());

        resource.add(linkTo.withRel("all"));

        return resource;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        paymentMethodRepository.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createStudent(@RequestBody PaymentMethod student) {
        PaymentMethod savedStudent = paymentMethodRepository.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getPaymentMethodId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody PaymentMethod paymentMethod, @PathVariable Integer id) {

        Optional<PaymentMethod> studentOptional = paymentMethodRepository.findById(id);

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();

        paymentMethod.setPaymentMethodId(id);

        paymentMethodRepository.save(paymentMethod);

        return ResponseEntity.noContent().build();
    }
}
