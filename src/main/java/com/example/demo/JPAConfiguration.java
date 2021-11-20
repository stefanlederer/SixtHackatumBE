package com.example.demo;

import com.example.demo.control.services.IdentificationService;
import com.example.demo.control.services.IdentificationServiceImpl;
import com.example.demo.control.services.UserService;
import com.example.demo.control.services.UserServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.example.demo.control" })
@ComponentScan("com.example.demo")
@PropertySource("classpath:application.properties")
public class JPAConfiguration {

    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    @Bean
    public IdentificationService getIdentificationService() {
        return new IdentificationServiceImpl();
    }

}
