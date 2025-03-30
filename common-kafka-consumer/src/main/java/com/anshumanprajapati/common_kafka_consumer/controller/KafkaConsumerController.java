package com.anshumanprajapati.common_kafka_consumer.controller;

import com.anshumanprajapati.common_kafka_consumer.service.KafkaConsumerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/producer")
public class KafkaConsumerController {

    private final KafkaConsumerService consumerService;

    public KafkaConsumerController(KafkaConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping(value = "/stream/messages", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamMessages() {
        return consumerService.getMessageStream();
    }
}