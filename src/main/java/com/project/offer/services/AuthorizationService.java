package com.project.offer.services;


import com.project.offer.entities.User;
import com.project.offer.exceptions.UserWithSuchLoginAlreadyExistsException;
import com.project.offer.forms.UserForm;
import com.project.offer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    GenerationService generationService;
    @Autowired
    ProducerService producerService;
    @Autowired
    HashingPasswordService hashingPasswordService;

    public User doAuthorization(UserForm userForm){
        if(!isUserExist(userForm)) {
            String generatedString = generationService.generateString();
            String name = userForm.getName();
            String login = userForm.getLogin();
            String password = userForm.getPassword();
            String hashPassword = hashingPasswordService.getSHA256HashOfString(password);

            User user = new User(name, login, hashPassword, generatedString);
            userRepository.save(user);
            producerService.send(user);
            return user;
        }
        else throw new UserWithSuchLoginAlreadyExistsException("Such user with such login already exists");
    }

    public boolean isUserExist(UserForm userForm){
        boolean userExisting;
        if(userRepository.findByLogin(userForm.getLogin()) == null){
            userExisting = false;
        }
        else{
            userExisting = true;
        }

        return userExisting;
    }

}
