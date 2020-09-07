package com.project.offer.services;

import com.project.offer.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Value("${spring.kafka.newUserTopic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void send(User user){
        kafkaTemplate.send(topic, user);
    }
}
