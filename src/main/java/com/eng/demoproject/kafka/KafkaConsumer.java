package com.eng.demoproject.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "firstTopic", groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message read from topic: %s",message));
    }
}
