package com.example.rabbitmq_demo;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Bean
    public Queue myQueue() {
        // Declare the queue with the name from application.yaml
        return new Queue(queueName, false);
    }

    @Bean
    public DirectExchange myExchange() {
        // Declare the exchange with the name from application.yaml
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        // Bind the queue to the exchange using the routing key
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }
}