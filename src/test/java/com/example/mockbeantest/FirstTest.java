package com.example.mockbeantest;

import static org.assertj.core.api.Assertions.*;

import com.example.mockbeantest.orderer.TestClassesOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@TestClassesOrder(1)
class FirstTest extends AbstractIntegrationTest {
  @Autowired
  private RabbitTemplate rabbitTemplate;
  @Autowired
  MessageConsumer messageConsumer;

  @Test
  void test() {
    System.out.println("FirstTest");
    rabbitTemplate.convertAndSend("amq.fanout", "", "test");
  }
}
