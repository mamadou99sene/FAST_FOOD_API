package uacd.master.sir.fast_food_api;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class FastFoodApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastFoodApiApplication.class, args);
    }

}
