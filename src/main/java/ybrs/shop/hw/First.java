package ybrs.shop.hw;

        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController()
public class First {
    @RequestMapping(name = "/hello")
    public Data sayHello() {
        return new Data(0, "Hello World!");
    }
}