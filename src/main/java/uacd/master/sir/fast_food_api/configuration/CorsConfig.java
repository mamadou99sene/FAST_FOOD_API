package uacd.master.sir.fast_food_api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // Autoriser toutes les origines (à ajuster selon vos besoins)
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Autoriser les méthodes HTTP spécifiées
                        .allowedHeaders("*"); // Autoriser tous les headers
            }
        };
    }
}
