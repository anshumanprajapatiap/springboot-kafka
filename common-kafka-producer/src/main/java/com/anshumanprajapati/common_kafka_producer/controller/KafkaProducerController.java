package com.anshumanprajapati.common_kafka_producer.controller;

import com.anshumanprajapati.common_kafka_producer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producer")
public class KafkaProducerController {

    private final KafkaProducerService producerService;

    @Autowired
    public KafkaProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String key, @RequestParam String message) {
        producerService.sendMessage(topic, key, message);
        return "Message sent successfully!";
    }
}