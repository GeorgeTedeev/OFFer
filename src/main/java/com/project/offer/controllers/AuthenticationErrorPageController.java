package com.project.offer.controllers;

import com.project.offer.exceptions.NoSuchLoginOrPasswordException;
import com.project.offer.forms.UserForm;
import com.project.offer.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthenticationErrorPageController {

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/authenticationErrorPage")
    public String addAttribute(Model model){
        model.addAttribute("userForm", new UserForm());
        return "authenticationErrorPage";
    }

    @PostMapping("/authenticationErrorPage")
    public String doAuthentication(@Valid @ModelAttribute("userForm") UserForm userForm){

        if (authenticationService.isUserExist(userForm) && authenticationService.isUserConfirmed(userForm)) return "confirmedUserHomePage";
        else if (authenticationService.isUserExist(userForm)) return "userHomePage";
        else throw new NoSuchLoginOrPasswordException("Such login or password doesn`t exist");


    }

    @ExceptionHandler(NoSuchLoginOrPasswordException.class)
    public String getErrorPage(){
        String redirect = "redirect:/authenticationErrorPage";
        return redirect;
    }
}
