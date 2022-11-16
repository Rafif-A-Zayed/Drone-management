package com.drones;


import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.zalando.logbook.Logbook;
import static org.zalando.logbook.Conditions.*;


@SpringBootApplication
@EnableScheduling
public class DronesApplication {
    public static void main(String[] args) {

        SpringApplication.run(DronesApplication.class, args);
    }

    @Bean
    public Logbook logBook() {
        return Logbook.builder()
                .condition(exclude(
                        requestTo("/health"),
                        requestTo("/admin/**"),
                        requestTo("/h2-console/**"),
                        contentType("application/octet-stream")))
                .build();

    }
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/h2-console/*");
        return registration;
    }
}
