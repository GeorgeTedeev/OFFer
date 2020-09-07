package com.project.offer.repositories;

import com.project.offer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
    User findByGeneratedString(String generatedString);
    User findByLoginAndPassword(String login, String password);

}
