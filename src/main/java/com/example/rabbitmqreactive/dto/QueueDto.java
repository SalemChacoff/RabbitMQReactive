package com.example.rabbitmqreactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueueDto {

    private String name;
    private String routingKey;
    private String exchange;
    private Boolean durable;
    private Boolean exclusive;
    private Boolean autoDelete;

}
