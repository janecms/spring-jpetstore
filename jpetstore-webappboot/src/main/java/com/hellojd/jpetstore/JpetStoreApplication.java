package com.hellojd.jpetstore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.hellojd.jpetstore")
public class JpetStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpetStoreApplication.class, args);
    }
}