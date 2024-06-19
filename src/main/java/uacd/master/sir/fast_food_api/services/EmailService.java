package uacd.master.sir.fast_food_api.services;

public interface EmailService {
    void sendSimpleMessage(String name, String to, String token);
}
