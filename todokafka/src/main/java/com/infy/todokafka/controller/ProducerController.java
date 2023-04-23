package com.infy.todokafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.todokafka.entity.ToDoItem;
import com.infy.todokafka.service.KafkaService;

@RestController
public class ProducerController {
    @Autowired
    KafkaService kafkaService;
   
    @PostMapping("/todo")
    public String sendMessage(@RequestBody ToDoItem toDoItem) {
    	kafkaService.send(toDoItem);
        return "Message sent successfully to the Kafka topic";
    }
   
    @PostMapping("/todolist")
    public String sendMessage(@RequestBody List<ToDoItem> toDoItem) {
    	kafkaService.sendList(toDoItem);
        return "Message sent successfully to the Kafka topic";
    }
    
}
