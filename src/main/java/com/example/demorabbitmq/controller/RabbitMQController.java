package com.example.demorabbitmq.controller;

import com.example.demorabbitmq.model.MessageSmsDto;
import com.example.demorabbitmq.producer.RabbitMQJsonProducer;
import com.example.demorabbitmq.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rabbit-mq")
public class RabbitMQController {
    private RabbitMQProducer rabbitMQProducer;
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public RabbitMQController(RabbitMQProducer rabbitMQProducer,
                              RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<?> sendMessage(@RequestParam("message") String message) {
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Sent message to RabbitMQ successfully");
    }

    @GetMapping("/publish-json")
    public ResponseEntity<?> sendJsonMessage(@RequestBody MessageSmsDto messageSmsDto) {
        rabbitMQJsonProducer.sendJsonMessage(messageSmsDto);
        return ResponseEntity.ok("Send json message to RabbitMQ successfully");
    }
}
