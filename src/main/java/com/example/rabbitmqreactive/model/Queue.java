package com.example.rabbitmqreactive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "queues")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Queue {

    @Id
    private String id;
    private String name;
    private String routingKey;
    private String exchange;
    private Boolean durable;
    private Boolean exclusive;
    private Boolean autoDelete;
}
