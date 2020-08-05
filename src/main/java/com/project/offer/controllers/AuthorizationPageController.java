package com.project.offer.controllers;


import com.project.offer.entities.User;
import com.project.offer.forms.UserForm;
import com.project.offer.services.AuthorizationService;
import com.project.offer.services.GetUserDTOByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthorizationPageController {

    @Autowired
    AuthorizationService authorizationService;
    @Autowired
    GetUserDTOByIdService getUserDTOByIdService;

    @GetMapping("/authorizationPage")
    String addAtribute(Model model){
        model.addAttribute("userForm", new UserForm());
        return "authorizationPage";
    }

    @PostMapping("/authorizationPage")
    String doAuthorization(@ModelAttribute("userForm") UserForm userForm){
        String name = userForm.getName();
        String login = userForm.getLogin();
        String password = userForm.getPassword();
        User user = authorizationService.doAuthorization(name, login, password);

        StringBuilder redirectBuilder = new StringBuilder("redirect:/email/send/");
        String redirect = redirectBuilder.append(user.getId()).append("/").append(login).toString();

        return redirect;
    }
}
