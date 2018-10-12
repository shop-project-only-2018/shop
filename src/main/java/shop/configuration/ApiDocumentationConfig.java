package shop.configuration;

import io.swagger.annotations.*;

@SwaggerDefinition(
        info = @Info(
                version = "V1.0.0",
                title = "Shop API"
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}
)

public interface ApiDocumentationConfig {
}