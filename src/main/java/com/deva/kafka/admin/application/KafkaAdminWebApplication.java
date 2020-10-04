package com.deva.kafka.admin.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.deva.kafka.admin.*")
public class KafkaAdminWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaAdminWebApplication.class, args);
    }
}