package com.example.rabbitmq_demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RabbitMQController {

    @Autowired
    private RabbitMQProducer producer;

    @Autowired
    private RabbitMQConsumer consumer;

    // GET request to load the form and display received messages (initially empty)
    @GetMapping("/")
    public String showMessageForm(Model model) {
        model.addAttribute("receivedMessages", new ArrayList<>());  // Initially, no received messages are shown
        return "message";
    }

    // POST request to send the message to RabbitMQ
    @PostMapping("/send")
    public String sendMessage(@RequestParam String message, Model model) {
        producer.sendMessage(message);  // Send the message to RabbitMQ

        // Return the form with no received messages shown (as we will not show sent messages here)
        model.addAttribute("receivedMessages", new ArrayList<>());
        return "message";
    }

    // GET request to fetch received messages from RabbitMQ
    @GetMapping("/get-received-messages")
    public String getReceivedMessages(Model model) {
        // Get the list of received messages from the consumer
        List<String> receivedMessages = consumer.getReceivedMessages();
        
        // Add the received messages to the model to be displayed
        model.addAttribute("receivedMessages", receivedMessages);
        
        return "message";
    }
}
