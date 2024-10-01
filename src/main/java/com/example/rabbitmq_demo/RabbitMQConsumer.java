package com.example.rabbitmq_demo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RabbitMQConsumer {

    private List<String> receivedMessages = new ArrayList<>();

    @RabbitListener(queues = "#{myQueue.name}")  // Listens to messages from RabbitMQ queue
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        receivedMessages.add(message);  // Store the received message
    }

    public List<String> getReceivedMessages() {
        return receivedMessages;
    }
}


