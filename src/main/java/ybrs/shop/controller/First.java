package ybrs.shop.controller;

        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import ybrs.shop.model.customer.Customer;
        import ybrs.shop.model.customer.Person;

@RestController()
public class First {
    @RequestMapping(name = "/hello")
    public Customer sayHello() {
        Customer c = new Customer();
        c.setPerson(new Person("John", "Wick"));
        return c;
    }
}