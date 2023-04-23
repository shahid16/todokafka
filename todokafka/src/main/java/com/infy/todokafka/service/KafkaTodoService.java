package com.infy.todokafka.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.todokafka.exception.ToDoItemNotFoundException;
import com.infy.todokafka.dao.KafkaToDoRepository;
import com.infy.todokafka.entity.ToDoItem;
 
@Service
public class KafkaTodoService {
    
	@Autowired
    private KafkaToDoRepository toDoRepository;
	private ToDoItem toDo;
   
    public void saveTodo(ToDoItem toDo) {
    	toDoRepository.save(toDo);
    }
   
    public Iterable<ToDoItem> findAllTodo() {
    return toDoRepository.findAll();
    }

	public ToDoItem fetchToDoById(Long toDoId) throws ToDoItemNotFoundException {
		// TODO Auto-generated method stub
		Optional<ToDoItem> toDoItem = Optional.ofNullable(
				toDoRepository.findById(toDoId).orElseThrow(() -> new ToDoItemNotFoundException("ToDoItem Not Found")));
		if(toDoItem.isPresent()) {
		  
			toDo = toDoItem.get();
			
		}
        
		return toDo;
	}   
}
