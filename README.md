# RabbitMQ Demo Application

This is a simple Spring Boot application that demonstrates how to use RabbitMQ for messaging. The application contains a producer that sends messages to a RabbitMQ queue and a consumer that listens to and processes messages from the queue.

## Table of Contents

- [Requirements](#requirements)
- [Setup](#setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Testing the Application](#testing-the-application)
- [Endpoints](#endpoints)
- [Useful Commands](#useful-commands)
- [Troubleshooting](#troubleshooting)
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
