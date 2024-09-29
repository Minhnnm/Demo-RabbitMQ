package com.example.demorabbitmq.producer;

import com.example.demorabbitmq.model.MessageSmsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonProducer {
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routing-jsonkey}")
    private String routingJonsKey;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendJsonMessage(MessageSmsDto messageSmsDto) {
        log.info("Json message sent -> " + messageSmsDto.toString());
        rabbitTemplate.convertAndSend(exchange, routingJonsKey, messageSmsDto);
    }
}
