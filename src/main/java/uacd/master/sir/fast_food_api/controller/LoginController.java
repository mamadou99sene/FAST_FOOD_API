package uacd.master.sir.fast_food_api.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import uacd.master.sir.fast_food_api.services.configuration.JWTService;

@RestController
public class LoginController {
    private final JWTService jwtService;

    public LoginController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/token")
    public String getToken(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}
