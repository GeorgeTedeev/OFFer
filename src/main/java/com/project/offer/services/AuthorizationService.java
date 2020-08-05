package com.project.offer.services;


import com.project.offer.entities.User;
import com.project.offer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    GetUserDTOByIdService getUserDTOByIdService;

    public User doAuthorization(String name, String login, String password){
        User user = new User(name, login, password);
        return userRepository.save(user);
    }
}
