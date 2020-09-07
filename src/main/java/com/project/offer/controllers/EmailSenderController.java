package com.project.offer.controllers;


import com.project.offer.entities.User;
import com.project.offer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Controller
@RequestMapping("/email")
public class EmailSenderController {

    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/send/{id}/{login}")
    public String sendEmail(@PathVariable("id") long id, @PathVariable("login") String login) throws MessagingException {

        User user = userRepository.findById(id).get();
        String link = "http://localhost:8080/confirm/";
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
        StringBuilder textBuilder = new StringBuilder("<html> <body><div style=\"text-align: center\"><h1>Confirm your page on OFFer, please follow this link:</h1> <a href=").append(link).append(user.getGeneratedString());
        textBuilder.append(">Сlick here to confirm</h2></div></body> </html>");
        String text = textBuilder.toString();
        helper.setTo(login);
        helper.setSubject("Confirm your page on OFFer");
        helper.setText(text, true);

        emailSender.send(message);

        StringBuilder redirectBuilder = new StringBuilder("redirect:/successfulAuthorizationPage/");
        String redirect = redirectBuilder.append(user.getId()).toString();

        return redirect;
    }
}
