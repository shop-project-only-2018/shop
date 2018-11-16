package shop.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
//@EnableSwagger2
@PropertySource("classpath:paths.properties")
public class ApplicationConfig implements WebMvcConfigurer {
    //    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.setUseSuffixPatternMatch(false);    }
//    @Bean(name = "templateResolver")
//    public ITemplateResolver getTemplateResolver() {
//        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setPrefix("/templates/");
//        resolver.setSuffix(".html");
//        resolver.setTemplateMode("XHTML");
//        return resolver;
//    }
//
//    @Bean(name = "templateEngine")
//    public SpringTemplateEngine getTemplateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(getTemplateResolver());
//        return templateEngine;
//    }
//
//    @Bean(name = "viewResolver")
//    public ThymeleafViewResolver getViewResolver() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(getTemplateEngine());
//        return viewResolver;
//    }
}