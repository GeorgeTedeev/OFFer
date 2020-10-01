package com.project.offer.services;

import com.project.offer.entities.User;
import com.project.offer.forms.UserForm;
import com.project.offer.forms.UserFormForAuthentication;
import com.project.offer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HashingPasswordService hashingPasswordService;

    public boolean isUserExist(UserFormForAuthentication userFormForAuthentication){
        boolean userExisting;
        String hashPassword = hashingPasswordService.getSHA256HashOfString(userFormForAuthentication.getPassword());
        if(userRepository.findByLoginAndPassword(userFormForAuthentication.getLogin(), hashPassword) == null){
            userExisting = false;
        }
        else {
            userExisting = true;
        }

        return userExisting;
    }

    public boolean isUserConfirmed(UserFormForAuthentication userFormForAuthentication){

        User user = userRepository.findByLogin(userFormForAuthentication.getLogin());

        return user.isConfirmFlag();

    }
}
