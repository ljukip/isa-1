package com.isa59.isa.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.isa59.isa.dto.PatientDTO;
import com.isa59.isa.model.User;

@Service
public class EmailService {
//TODO: Make IEmailService

    @Autowired
    private JavaMailSender javaMailSender;

    // Use a class to read values from the application.properties file
    @Autowired
    private Environment env;

    /*
     * Annotation for marking an asynchronous task
     * More info on: https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling
     */
    @Async
    public void sendActivationEmailAsync(PatientDTO patientDTO) throws MailException, InterruptedException {
        System.out.println("Email sending...\n\n");

        String endPointForAccountActivation = "/auth/" + "activate/" + patientDTO.getUsername();

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(patientDTO.getUsername());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Activate account [ISA]");
        mail.setText(
                "Welcome, " + patientDTO.getFirstname() + "," + " activate your account on this link: "
                        + "http://localhost:" + "8086" + endPointForAccountActivation
        );
        javaMailSender.send(mail);

        System.out.println("Email was send!");
    }

}

