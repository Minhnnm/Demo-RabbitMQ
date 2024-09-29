package com.example.demorabbitmq.consumer;

import com.example.demorabbitmq.model.MessageSmsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${spring.rabbitmq.json-queue}"})
    public void consumeJsonMessage(MessageSmsDto message){
        log.info("Received message -> " + message);
    }
}
