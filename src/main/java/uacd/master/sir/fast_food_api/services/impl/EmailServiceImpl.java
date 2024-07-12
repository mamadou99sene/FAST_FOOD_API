package uacd.master.sir.fast_food_api.services.impl;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import uacd.master.sir.fast_food_api.services.EmailService;
import uacd.master.sir.fast_food_api.utils.EmailUtils;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.context.Context;


import java.util.Map;


@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    public static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";

    private static final String UTF_8_ENCODING = "UTF-8";
    public static final String EMAIL_TEMPLATE = "emailTemplate";

    private final TemplateEngine templateEngine;

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

    @Override
    @Async
    public void sendHtmlMessage(String name, String to, String token) {
        try {
            Context context = new Context();
            context.setVariables(Map.of("name",name, "url", EmailUtils.getVerifiactionUrl(host, token)));

            String text = templateEngine.process(EMAIL_TEMPLATE, context);

            MimeMessage message = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);

            helper.setPriority(1);
            helper.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            helper.setFrom(fromEmail, "LO AM NOCE ");
            helper.setTo(to);
            helper.setText(text, true );

            //Add attachments au besoin
//            FileSystemResource vega = new FileSystemResource(new File("src/main/resources/static/Vega.png"));
//            FileSystemResource disque = new FileSystemResource(new File("src/main/resources/static/disque_2.png"));
//            FileSystemResource logo = new FileSystemResource(new File("src/main/resources/static/N_Noel.png"));
//            FileSystemResource pdf = new FileSystemResource(new File("src/main/resources/static/M1_Examen.pdf"));
//
//            helper.addInline(getContentId(Objects.requireNonNull(disque.getFilename())), disque);
//            helper.addInline(getContentId(Objects.requireNonNull(vega.getFilename())), vega);
//            helper.addInline(getContentId(Objects.requireNonNull(logo.getFilename())), logo);
//            helper.addInline(getContentId(Objects.requireNonNull(pdf.getFilename())), pdf);

            emailSender.send(message);

        }catch (Exception exception){
            throw  new RuntimeException(exception.getMessage());
        }
    }

    private MimeMessage getMimeMessage() {
        return emailSender.createMimeMessage();
    }

    private String getContentId(String fileName) {
        return "<" + fileName + ">";
    }
}
