package shop.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;

/**
 * Auxiliary class for making the code clearer
 */
public class ResponseEntityBuilder {

    public static ResponseEntity<Void> ok() {
        return ResponseEntity.ok().build();
    }

    public static ResponseEntity<Void> badRequest() {
        return ResponseEntity.badRequest().build();
    }

    public static ResponseEntity<Void> notFound() {
        return ResponseEntity.noContent().build();
    }

    public static ResponseEntity<Void> noContent() {
        return ResponseEntity.noContent().build();
    }

    public static ResponseEntity<Void> created(@NotNull Integer id) {
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + id.toString()).build().toUri()).build();
    }
}
