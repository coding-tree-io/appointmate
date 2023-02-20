package io.coding.tree.appointmate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableAsync
@ConfigurationPropertiesScan
public class AppointMateApplication {

    public static void main(String[] args) {
        run(AppointMateApplication.class, args);
    }
}
