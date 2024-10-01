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