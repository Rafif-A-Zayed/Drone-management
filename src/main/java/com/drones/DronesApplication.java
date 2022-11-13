package com.drones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class DronesApplication {
    public static void main(String[] args) {

        SpringApplication.run(DronesApplication.class, args);
    }
}
