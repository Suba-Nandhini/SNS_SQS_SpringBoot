package com.example.sns_sqs_aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {


    @Autowired
    private SnsPublisherService snsPublisherService;

    public MessageController(SnsPublisherService snsPublisherService){
        this.snsPublisherService=snsPublisherService;
    }

    @GetMapping("/publish")
    public String publicMessage(@RequestBody String message){
        return snsPublisherService.publishMessage(message);
    }
}
