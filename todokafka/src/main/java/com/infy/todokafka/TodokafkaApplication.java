package com.infy.todokafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication
public class TodokafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodokafkaApplication.class, args);
	}

}
