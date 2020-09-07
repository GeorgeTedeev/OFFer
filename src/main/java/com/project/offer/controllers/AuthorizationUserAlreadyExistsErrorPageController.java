package com.project.offer.controllers;


import com.project.offer.entities.User;
import com.project.offer.exceptions.UserWithSuchLoginAlreadyExistsException;
import com.project.offer.forms.UserForm;
import com.project.offer.services.AuthorizationService;
import com.project.offer.services.GetUserDTOByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthorizationUserAlreadyExistsErrorPageController {

    @Autowired
    AuthorizationService authorizationService;
    @Autowired
    GetUserDTOByIdService getUserDTOByIdService;

    @GetMapping("/authorizationUserAlreadyExistsErrorPage")
    String addAttribute(Model model){
        model.addAttribute("userForm", new UserForm());
        return "authorizationUserAlreadyExistsErrorPage";
    }

    @PostMapping("/authorizationUserAlreadyExistsErrorPage")
    String doAuthorization(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult){

        String redirect;

        if (bindingResult.hasErrors()) {
            redirect = "redirect:/authorizationValidErrorPage";
            return redirect;
        }

        User user = authorizationService.doAuthorization(userForm);
        StringBuilder redirectBuilder = new StringBuilder("redirect:/email/send/");
        redirect = redirectBuilder.append(user.getId()).append("/").append(user.getLogin()).toString();

        return redirect;
    }

    @ExceptionHandler(UserWithSuchLoginAlreadyExistsException.class)
    public String getErrorPage(){
        String redirect = "redirect:/authorizationUserAlreadyExistsErrorPage";
        return redirect;
    }
}
