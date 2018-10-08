package shop.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class ApplicationConfig implements WebMvcConfigurer {

    /**
     * Swagger configuration.
     *
     * @return docket bean
     */
    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("shop.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket.globalOperationParameters(
                Collections.singletonList(
                        new ParameterBuilder()
                                .name(HttpHeaders.AUTHORIZATION)
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(false)
                                .build()
                )
        );
    }


    /**
     * Suffix pattern matching disabling.
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    /**
     * Resource handlers configuration.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}