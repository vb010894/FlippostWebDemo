package com.vbsoft.flippoststarter;

import org.hibernate.dialect.PostgreSQLDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.vbsoft")
@EnableJpaRepositories(basePackages = "com.vbsoft.**")
@EntityScan("com.vbsoft.**")
@SpringBootApplication(scanBasePackages = {"com.vbsoft"})
public class FlippostStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlippostStarterApplication.class, args);
    }

}
