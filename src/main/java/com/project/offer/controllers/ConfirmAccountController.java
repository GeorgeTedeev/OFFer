package com.project.offer.controllers;


import com.project.offer.dto.UserDTO;
import com.project.offer.entities.User;
import com.project.offer.repositories.UserRepository;
import com.project.offer.services.GetUserDTOByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/confirm")
public class ConfirmAccountController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    GetUserDTOByIdService getUserDTOByIdService;

    @GetMapping("/{generatedString}")
    public String setConfirmFlag(@PathVariable("generatedString") String generatedString, Model model){

        User user = userRepository.findByGeneratedString(generatedString);
        user.setConfirmFlag(true);
        user.setGeneratedString("");
        userRepository.save(user);

        UserDTO userDTO = getUserDTOByIdService.getUserDTOById(user.getId());
        model.addAttribute("userDTO", userDTO);

        return "successfulConfirmedPage";
    }

}
