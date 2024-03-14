package com.eng.demoproject.kafka;

import com.eng.demoproject.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class JsonKafkaConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "firstTopicJson", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("User consumed from topic: %s",user.toString()));
    }
}
