# RabbitMQ Demo Application

This is a simple Spring Boot application that demonstrates how to use RabbitMQ for messaging. The application contains a producer that sends messages to a RabbitMQ queue and a consumer that listens to and processes messages from the queue.

![](docs/images/ui.png)

## Table of Contents

- [Requirements](#requirements)
- [Setup](#setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Contribute](#contribute)
- [License](#license)

## Requirements

To run this application, you will need:

- Java 21
- Maven
- Docker

## Setup

### 1. Clone the repository

```bash
git clone https://github.com/spuchol81/rabbitmq-demo.git
cd rabbitmq-demo
```

### 2. Build the project
```bash
./mvnw clean install
```

## Configuration
Everything should work out of the box, as rabbitMQ credentials have been aligned in the application configuration and the docker compose specification

application.yaml
```yaml
spring:
  application:
    name: rabbitmq-demo
  rabbitmq:
    username: guest
    password: guest
rabbitmq.exchange.name: my_exchange     # Name of the exchange
rabbitmq.queue.name: my_queue        # Name of the queue
rabbitmq.routing.key: my_routing_key   # Routing key to bind the queue to the exchange
```
compose.yaml
```yaml
services:
  rabbitmq:
    image: rabbitmq:3-management
    container_name: rabbitmq
    ports:
      - "5672:5672"  # AMQP port
      - "15672:15672" # Management UI port
    environment:
      RABBITMQ_DEFAULT_USER: guest
      RABBITMQ_DEFAULT_PASS: guest
```
## Running the application
Start the application
```bash
./mvnw spring-boot:run
```
You can access the application here: [RabbitMQ Demo App](http://localhost:8080)

## Contribute

Contributions are always welcome!

Feel free to open issues & send PR.

## License

Copyright &copy; 2024 [Broadcom, Inc. or its affiliates](https://vmware.com).

This project is licensed under the [Apache Software License version 2.0](https://www.apache.org/licenses/LICENSE-2.0).