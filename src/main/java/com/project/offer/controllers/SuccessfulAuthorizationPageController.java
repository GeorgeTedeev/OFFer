package com.project.offer.controllers;

import com.project.offer.dto.UserDTO;

import com.project.offer.services.GetUserDTOByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SuccessfulAuthorizationPageController {

    @Autowired
    GetUserDTOByIdService getUserDTOByIdService;

    @GetMapping("/successfulAuthorizationPage/{id}")
    public String addAtribute(@PathVariable("id") long id, Model model){
        UserDTO userDTO = getUserDTOByIdService.getUserDTOById(id);
        model.addAttribute("userDTO", userDTO);

        return "successfulAuthorizationPage";
    }

}
