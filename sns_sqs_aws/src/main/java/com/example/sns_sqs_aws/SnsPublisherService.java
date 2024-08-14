package com.example.sns_sqs_aws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
public class SnsPublisherService {
    @Autowired
    private SnsClient snsClient;

    @Value("${sns.topic.arn}")
    private String snsTopicArn;


    public SnsPublisherService(SnsClient snsClient){
        this.snsClient=snsClient;
    }

    public String publishMessage(String message){

        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(snsTopicArn)
                .message(message)
                .build();


        PublishResponse publishResponse = snsClient.publish(publishRequest);
        return publishResponse.messageId();

    }
}
