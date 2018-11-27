package shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({
        "shop.model"
})
@EnableJpaRepositories({
        "shop.repository.customer",
        "shop.repository.product",
        "shop.repository.order"
})
@ComponentScan({
        "shop.configuration",
        "shop.service",
        "shop.controller",
        "shop.mappers"
})
public class ShopApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {SpringApplication.run(ShopApplication.class, args);}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ShopApplication.class);
    }

}
