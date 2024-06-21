package com.example.rabbitmqreactive.service;

import com.example.rabbitmqreactive.dto.QueueDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QueueReactiveService {

    public Mono<QueueDto> createQueue(QueueDto queue);
    public Flux<QueueDto> getQueue(String name);
    public Mono<QueueDto> updateQueue(String name, QueueDto queue);
    public Mono<Void> deleteQueue(String name);
    public Flux<QueueDto> subscribeQueues();
}
