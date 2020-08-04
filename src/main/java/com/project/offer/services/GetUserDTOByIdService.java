package com.project.offer.services;

import com.project.offer.dto.UserDTO;
import com.project.offer.entities.User;
import com.project.offer.exceptions.NoEntityWithSuchIdException;
import com.project.offer.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserDTOByIdService {

    @Autowired
    UserRepository userRepository;

    public UserDTO getUserDTOById(Long idOfUser){
        UserDTO userDTO = convertToDTO(getUserById(idOfUser));
        return userDTO;

    }
    public User getUserById(Long idOfUser){
        Optional<User> user = userRepository.findById(idOfUser);
        return user.orElseThrow(()-> new NoEntityWithSuchIdException(String.format("No such user with id = ",idOfUser)));
    }

    public UserDTO convertToDTO(User user){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDTO.class);
    }


}
