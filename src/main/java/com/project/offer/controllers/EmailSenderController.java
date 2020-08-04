package com.project.offer.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
public class EmailSenderController {

    @Autowired
    private JavaMailSender emailSender;

    @GetMapping("/send/{id}/{login}")
    public String sendEmail(@PathVariable("id") long id, @PathVariable("login") String login){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(login);
        message.setSubject("Confirming your page on OFFer");
        //Тут надо будет юзера получить и флажок подтверждения сделать тру и забрать у него стринг,
        //который автоматический генерируется и отпарлять ссылку юзера, где в юрл этот стринг уникальный,
        //и потом думаю этот стринг делать empty, чтобы вероятность, что сгенериться и совпадет стринг у разных была меньше
        message.setText("https://www.baeldung.com/spring-email");
        emailSender.send(message);

        StringBuilder redirectBuilder = new StringBuilder("redirect:/successfulAuthorizationPage/");
        String redirect = redirectBuilder.append(id).toString();

        return redirect;
    }
}
