package shop.mappers.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Component
public class CustomerURIMapper {

    private final String customerApiPath = "customer";

    private URI toURI(String prefix, Integer identifier) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path(prefix).path("/" + identifier).build().toUri();
    }

    public URI toURI(Integer identifier) {
        return toURI(customerApiPath, identifier);
    }

}
