package com.example.mockbeantest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.RabbitMQContainer;


@SpringBootTest
class AbstractIntegrationTest {

  static RabbitMQContainer rabbitMQ = new RabbitMQContainer("rabbitmq:3.9.5-alpine");

  static {
    rabbitMQ.start();
  }

  @DynamicPropertySource
  static void setRabbitMQ(DynamicPropertyRegistry registry) {
    registry.add("spring.rabbitmq.host", () -> "localhost");
    registry.add("spring.rabbitmq.port", () -> rabbitMQ.getAmqpPort());
    registry.add("spring.rabbitmq.username", () -> rabbitMQ.getAdminUsername());
    registry.add("spring.rabbitmq.password", () -> rabbitMQ.getAdminPassword());
  }
}
