package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.example.Zoo;
import org.example.animals.Monkey;
import org.example.animals.Rabbit;
import org.example.animals.Tiger;
import org.example.animals.Wolf;
import org.example.inventory.Computer;
import org.example.inventory.Table;
import org.example.services.VetClinic;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {
    @Bean
    public VetClinic vetClinic() {
        return new VetClinic();
    }

    @Bean
    public Zoo zoo(VetClinic vetClinic) {
        return new Zoo(vetClinic);
    }

    @Bean
    public Monkey monkey() {
        return new Monkey(101, 7);
    }

    @Bean
    public Rabbit rabbit() {
        return new Rabbit(102, 4);
    }

    @Bean
    public Tiger tiger() {
        return new Tiger(103);
    }

    @Bean
    public Wolf wolf() {
        return new Wolf(104);
    }

    @Bean
    public Table table() {
        return new Table(201);
    }

    @Bean
    public Computer computer() {
        return new Computer(202);
    }
}
