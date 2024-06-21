package com.example.rabbitmqreactive.serviceImpl;

import com.example.rabbitmqreactive.dto.QueueDto;
import com.example.rabbitmqreactive.model.Queue;
import com.example.rabbitmqreactive.repository.QueueReactiveRepository;
import com.example.rabbitmqreactive.service.QueueReactiveService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QueueReactiveServiceImpl implements QueueReactiveService {

    private final QueueReactiveRepository queueReactiveRepository;

    public QueueReactiveServiceImpl(QueueReactiveRepository queueReactiveRepository) {
        this.queueReactiveRepository = queueReactiveRepository;
    }


    @Override
    public Mono<QueueDto> createQueue(QueueDto queue) {
        Queue queueModel = new Queue();
        queueModel.setName(queue.getName());
        queueModel.setRoutingKey(queue.getRoutingKey());
        queueModel.setExchange(queue.getExchange());
        queueModel.setDurable(queue.getDurable());
        queueModel.setExclusive(queue.getExclusive());
        queueModel.setAutoDelete(queue.getAutoDelete());
        return queueReactiveRepository.save(queueModel)
                .map(savedQueue -> {
                    QueueDto queueDto = new QueueDto();
                    queueDto.setName(savedQueue.getName());
                    queueDto.setRoutingKey(savedQueue.getRoutingKey());
                    queueDto.setExchange(savedQueue.getExchange());
                    queueDto.setDurable(savedQueue.getDurable());
                    queueDto.setExclusive(savedQueue.getExclusive());
                    queueDto.setAutoDelete(savedQueue.getAutoDelete());
                    return queueDto;
                });
    }

    @Override
    public Flux<QueueDto> getQueue(String name) {
        Flux<Queue> queueMono = queueReactiveRepository.findByName(name);
        return queueMono.map(queue -> {
            QueueDto queueDto = new QueueDto();
            queueDto.setName(queue.getName());
            queueDto.setRoutingKey(queue.getRoutingKey());
            queueDto.setExchange(queue.getExchange());
            queueDto.setDurable(queue.getDurable());
            queueDto.setExclusive(queue.getExclusive());
            queueDto.setAutoDelete(queue.getAutoDelete());
            return queueDto;
        });
    }

    @Override
    public Mono<QueueDto> updateQueue(String name, QueueDto queue) {
        Mono<Queue> queueMono = queueReactiveRepository.findByName(name).next();
        return queueMono.flatMap(queueModel -> {
            queueModel.setName(queue.getName());
            queueModel.setRoutingKey(queue.getRoutingKey());
            queueModel.setExchange(queue.getExchange());
            queueModel.setDurable(queue.getDurable());
            queueModel.setExclusive(queue.getExclusive());
            queueModel.setAutoDelete(queue.getAutoDelete());
            return queueReactiveRepository.save(queueModel);
        }).map(savedQueue -> {
            QueueDto queueDto = new QueueDto();
            queueDto.setName(savedQueue.getName());
            queueDto.setRoutingKey(savedQueue.getRoutingKey());
            queueDto.setExchange(savedQueue.getExchange());
            queueDto.setDurable(savedQueue.getDurable());
            queueDto.setExclusive(savedQueue.getExclusive());
            queueDto.setAutoDelete(savedQueue.getAutoDelete());
            return queueDto;
        });
    }

    @Override
    public Mono<Void> deleteQueue(String name) {
        return queueReactiveRepository.deleteById(name);
    }

    @Override
    public Flux<QueueDto> subscribeQueues() {
        return queueReactiveRepository.findAll().map(queue -> {
            QueueDto queueDto = new QueueDto();
            queueDto.setName(queue.getName());
            queueDto.setRoutingKey(queue.getRoutingKey());
            queueDto.setExchange(queue.getExchange());
            queueDto.setDurable(queue.getDurable());
            queueDto.setExclusive(queue.getExclusive());
            queueDto.setAutoDelete(queue.getAutoDelete());
            return queueDto;
        });
    }
}
