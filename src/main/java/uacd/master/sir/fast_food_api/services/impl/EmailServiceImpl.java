package uacd.master.sir.fast_food_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.services.EmailService;
import uacd.master.sir.fast_food_api.utils.EmailUtils;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    public static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";


    @Value("${spring.mail.verify.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String fromEmail;
    private final JavaMailSender emailSender;

    @Override
    @Async
    public void sendSimpleMessage(String name, String to, String token) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setText(EmailUtils.getEmailMessage(name, host, token));

            emailSender.send(message);
        }catch (Exception exception){
            throw  new RuntimeException(exception.getMessage());
        }
    }
}
