package shop.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableSwagger2
@PropertySource("classpath:paths.properties")
public class ApplicationConfig implements WebMvcConfigurer {
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.setUseSuffixPatternMatch(false);    }
}