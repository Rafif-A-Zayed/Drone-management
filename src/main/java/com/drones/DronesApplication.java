package com.drones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
                        contentType("application/octet-stream")))
                .build();

    }
}
