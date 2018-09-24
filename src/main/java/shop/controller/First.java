package shop.controller;

        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import shop.model.customer.Customer;
        import shop.model.customer.Person;

@RestController()
public class First {
    @RequestMapping(name = "/hello")
    public Customer sayHello() {
        Customer c = new Customer();
        return c;
    }
}