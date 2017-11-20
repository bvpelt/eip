package nl.bsoft.eip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class EipDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EipDemoApplication.class, args);
    }
}
