package com.example.mockbeantest;

import org.springframework.amqp.rabbit.annotation.Argument;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
  private final BeanToConsume bean;

  public MessageConsumer(BeanToConsume bean) {
    this.bean = bean;
  }

  @RabbitListener(bindings = {
      @QueueBinding(
          value = @Queue(value = "test", durable = "true"),
          exchange = @Exchange(value = "amq.fanout", type = "fanout")
      )
  })
  public void getBean() {
    System.out.println("BeanToConsume is of type: " + bean.getClass().getName());
  }
}
