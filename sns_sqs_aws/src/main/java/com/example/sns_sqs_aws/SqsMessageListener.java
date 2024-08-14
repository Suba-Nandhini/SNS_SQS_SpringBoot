package com.example.sns_sqs_aws;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsMessageListener {
    @SqsListener("${cloud.aws.sqs.queue-name}")
    public void receiveMessage(String message){
        System.out.println("Received message from SQS : "+ message);
    }
}
