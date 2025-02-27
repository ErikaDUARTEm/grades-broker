package com.example.gradesconsumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
  private static final String QUEUE_NAME = "ecommerce_queue";

  @Bean
  public Queue queue() {
    return new Queue(QUEUE_NAME);
  }
  @Bean
  public Jackson2JsonMessageConverter messageConverter(){
    return new Jackson2JsonMessageConverter();
  }
}
