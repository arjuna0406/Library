package com.study.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.study.firstapp.repository"})
@EnableJpaAuditing(auditorAwareRef = "appAuditorAware")
@EnableTransactionManagement
public class FirstAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstAppApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorProvider(){
        return new AppAuditorAware();
    }
}
