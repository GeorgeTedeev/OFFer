package com.project.offer.services;

import com.project.offer.entities.User;
import com.project.offer.forms.UserForm;
import com.project.offer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HashingPasswordService hashingPasswordService;

    public boolean isUserExist(UserForm userForm){
        boolean userExisting;
        String hashPassword = hashingPasswordService.getSHA256HashOfString(userForm.getPassword());
        if(userRepository.findByLoginAndPassword(userForm.getLogin(), hashPassword) == null){
            userExisting = false;
        }
        else {
            userExisting = true;
        }

        return userExisting;
    }

    public boolean isUserConfirmed(UserForm userForm){

        User user = userRepository.findByLogin(userForm.getLogin());

        return user.isConfirmFlag();

    }
}
