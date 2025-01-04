package com.anshumanprajapati.common_kafka_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class KafkaConsumerService {
    private final Sinks.Many<String> sink;

    public KafkaConsumerService() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    @KafkaListener(topics = "example-topic", groupId = "group_id")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
        sink.tryEmitNext(message);
    }

    public Flux<String> getMessageStream() {
        return sink.asFlux();
    }
}