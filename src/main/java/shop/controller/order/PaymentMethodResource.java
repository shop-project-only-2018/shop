package shop.controller.order;


import io.swagger.annotations.ApiOperation;
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
    public List<PaymentMethod> retrieveAllStudents() {
        return paymentMethodRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find PaymentMethod by id",
            notes = "Also returns a link to retrieve all PaymentMethods with rel - all")
    public Resource<PaymentMethod> retrieveStudent(@PathVariable Integer id) {
        Optional<PaymentMethod> student = paymentMethodRepository.findById(id);

//        if (!student.isPresent())
//            throw new StudentNotFoundException("id-" + id);

        Resource<PaymentMethod> resource = new Resource<PaymentMethod>(student.get());

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllStudents());

        resource.add(linkTo.withRel("all"));

        return resource;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
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
    public ResponseEntity<Object> updateStudent(@RequestBody PaymentMethod student, @PathVariable Integer id) {

        Optional<PaymentMethod> studentOptional = paymentMethodRepository.findById(id);

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();

        student.setPaymentMethodId(id);

        paymentMethodRepository.save(student);

        return ResponseEntity.noContent().build();
    }
}
