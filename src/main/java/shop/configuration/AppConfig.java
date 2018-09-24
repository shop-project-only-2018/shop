package shop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@EnableTransactionManagement
public class AppConfig {

//    @Bean
//    public EntityManagerFactory entityManagerFactory(){
//        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("shop.model");
//        return emf;
//    }
}