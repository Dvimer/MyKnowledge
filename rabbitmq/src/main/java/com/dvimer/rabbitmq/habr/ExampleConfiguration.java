package com.dvimer.rabbitmq.habr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@ComponentScan
@Import(RabbitConfiguration.class)
public class ExampleConfiguration {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleConfiguration.class, args);
    }
}