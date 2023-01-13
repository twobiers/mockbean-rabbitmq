package com.example.mockbeantest;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.mockbeantest.orderer.TestClassesOrder;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestClassesOrder(2)
public class SecondTest extends AbstractIntegrationTest {
  @MockBean
  BeanToConsume beanToConsume;

  @Autowired
  RabbitTemplate rabbitTemplate;

  @Autowired
  MessageConsumer messageConsumer;

  @Test
  void test() {
    System.out.println("SecondTest");
    rabbitTemplate.convertAndSend("amq.fanout", "", "test");
  }
}
