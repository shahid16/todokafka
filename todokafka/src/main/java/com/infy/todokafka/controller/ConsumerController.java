package com.infy.todokafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infy.todokafka.exception.ToDoItemNotFoundException;
import com.infy.todokafka.entity.ToDoItem;
import com.infy.todokafka.service.KafkaTodoService;

@RestController
public class ConsumerController {
    @Autowired
    KafkaTodoService kafkaTodoService;
   
    

    @KafkaListener(topics = "todo_topic", groupId = "todo-group")
    public void listen(ToDoItem toDoItem) {
        System.out.println("Received todo information : " + toDoItem.toString());
        try {
        	kafkaTodoService.saveTodo(toDoItem);
        } catch (Exception e) {
            e.printStackTrace();   
        }
    }
   
    @GetMapping("/getTodoFromKafka")
    public Iterable<ToDoItem> findAllUser() {
        return kafkaTodoService.findAllTodo();
    }
    
    @GetMapping("/ToDo/{id}")
	public ResponseEntity<ToDoItem> fetchToDoById(@PathVariable("id") final Long toDoId) throws ToDoItemNotFoundException, JsonProcessingException {
		
		ToDoItem toDoItem = kafkaTodoService.fetchToDoById(toDoId);
		  return new ResponseEntity<>(toDoItem, HttpStatus.OK);

	}

	/*
	 * @GetMapping("/search") public ResponseEntity<List<ToDoItem>>
	 * searchToDo(@RequestParam("key") String key) {
	 * 
	 * List<ToDoItem> toDoList = todoService.searchToDo(key); return new
	 * ResponseEntity<>(toDoList,HttpStatus.OK); }
	 * 
	 * @PutMapping("/ToDo/{toDoId}") public ResponseEntity<ToDoItem>
	 * updateToDoItem(@PathVariable("toDoId") Long toDoId, @RequestBody ToDoItem
	 * toDoItem) throws ToDoItemNotFoundException {
	 * 
	 * ToDoItem savedtoDoItem = todoService.fetchToDoById(toDoId);
	 * 
	 * savedtoDoItem.setTaskName(toDoItem.getTaskName());
	 * savedtoDoItem.setExpectedDate(toDoItem.getExpectedDate());
	 * savedtoDoItem.setPriority(toDoItem.getPriority().getValue());
	 * 
	 * ToDoItem updatedtoDoItem = todoService.updateToDoItem(savedtoDoItem);
	 * 
	 * return new ResponseEntity<>(updatedtoDoItem, HttpStatus.OK); }
	 * 
	 * 
	 * 
	 * @DeleteMapping("/ToDo/{id}") public String deleteToDoById(@PathVariable("id")
	 * Long toDoId) {
	 * 
	 * 
	 * return todoService.deleteToDoById(toDoId); }
	 */
}
