package com.example.rabbitmqreactive.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "messages")
public class Message {


    private String id;
    private String content;
    private String queue;
    private String routingKey;
    private String deliveryMode;
    private String priority;
    private LocalDateTime timestamp;
    private LocalDateTime expiration;

}
