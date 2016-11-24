package com.epam.mentorship.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(
        value = { "application.properties", "rest-application.properties" })
public class ApplicationInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(ApplicationInitializer.class, args);
    }
}
