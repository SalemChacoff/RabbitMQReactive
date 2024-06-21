package com.example.rabbitmqreactive.controller;

import com.example.rabbitmqreactive.dto.QueueDto;
import com.example.rabbitmqreactive.service.QueueReactiveService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/queues")
public class QueueReactiveController {

    private final QueueReactiveService queueReactiveService;

    public QueueReactiveController(QueueReactiveService queueReactiveService) {
        this.queueReactiveService = queueReactiveService;
    }

    @PostMapping("/create")
    public Mono<QueueDto> createQueue(@RequestBody QueueDto queueDto) {
        return queueReactiveService.createQueue(queueDto);
    }

    @GetMapping("/get/{name}")
    public Flux<QueueDto> getQueue(@PathVariable("name") String name) {
        return queueReactiveService.getQueue(name);
    }

    @PostMapping("/update/{name}")
    public Mono<QueueDto> updateQueue(@PathVariable("name") String name, @RequestBody QueueDto queueDto) {
        return queueReactiveService.updateQueue(name, queueDto);
    }
    
    @DeleteMapping("/delete/{name}")
    public Mono<Void> deleteQueue(@PathVariable("name") String name) {
        return queueReactiveService.deleteQueue(name);
    }

    @GetMapping("/subscribe")
    public Flux<QueueDto> subscribeQueues() {
        return queueReactiveService.subscribeQueues();
    }
}
