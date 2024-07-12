package uacd.master.sir.fast_food_api;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uacd.master.sir.fast_food_api.services.EmailService;

@SpringBootApplication
@AllArgsConstructor
public class FastFoodApiApplication {

    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(FastFoodApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner (){

        return args -> {
            // Code exécuté au démarrage de l'application
            System.out.println("Application démarrée !");
            // Effectuer d'autres tâches de configuration ou de démarrage
//            emailService.sendHtmlMessage("Moussa", "netrathior@gmail.com", "00000000000000000");
        };

    }

}
