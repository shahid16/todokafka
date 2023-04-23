package com.infy.todokafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.infy.todokafka.entity.ToDoItem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import java.util.*;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Bean
    public ConsumerFactory<String, ToDoItem> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9093");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "todo-group");
        return new DefaultKafkaConsumerFactory<>(props,
            new StringDeserializer(), new JsonDeserializer<>(ToDoItem.class));
    }
   
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ToDoItem>
      kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ToDoItem> factory =
          new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
   
}
