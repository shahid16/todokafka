package com.infy.todokafka.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.infy.todokafka.entity.ToDoItem;
 
@Service
public class KafkaService {
	
    private final Logger LOG = LoggerFactory.getLogger(KafkaService.class);
    @Autowired
    private KafkaTemplate<String, ToDoItem> kafkaTemplate;
    String kafkaTopic = "todo_topic";
    
    public void send(ToDoItem toDoItem) {
        LOG.info("Sending User Json Serializer : {}", toDoItem);
        kafkaTemplate.send(kafkaTopic, toDoItem);
    }
    
    public void sendList(List<ToDoItem> toDoList) {
        LOG.info("Sending UserList Json Serializer : {}", toDoList);
        for (ToDoItem toDoItem : toDoList) {
            kafkaTemplate.send(kafkaTopic, toDoItem);
        }
    }
}
