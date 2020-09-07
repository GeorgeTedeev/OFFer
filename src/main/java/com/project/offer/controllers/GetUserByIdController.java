package com.project.offer.controllers;


import com.project.offer.dto.UserDTO;
import com.project.offer.exceptions.NoEntityWithSuchIdException;
import com.project.offer.services.GetUserDTOByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/get/user")
public class GetUserByIdController {

    @Autowired
    GetUserDTOByIdService getUserDTOByIdService;


    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id){
        return getUserDTOByIdService.getUserDTOById(id);
    }

    @ExceptionHandler(NoEntityWithSuchIdException.class)
    public String getNoSuchEntityMessage(){
        String error = "authorizationErrorPage";
        return error;
    }

}
