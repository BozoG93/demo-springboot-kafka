package com.eng.demoproject.controller;

import com.eng.demoproject.kafka.JsonKafkaProducer;
import com.eng.demoproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    public JsonMessageController (JsonKafkaProducer jsonKafkaProducer){
        this.jsonKafkaProducer = jsonKafkaProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String>publish(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
