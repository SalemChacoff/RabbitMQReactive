package com.example.rabbitmqreactive.repository;

import com.example.rabbitmqreactive.model.Queue;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface QueueReactiveRepository extends ReactiveCrudRepository<Queue, String>{

    Flux<Queue> findByName(String name);

}
