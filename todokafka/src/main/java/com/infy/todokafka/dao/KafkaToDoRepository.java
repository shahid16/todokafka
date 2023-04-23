package com.infy.todokafka.dao;

import org.springframework.data.repository.CrudRepository;

import com.infy.todokafka.entity.ToDoItem;

public interface KafkaToDoRepository extends CrudRepository<ToDoItem, Long> {
	 

}
