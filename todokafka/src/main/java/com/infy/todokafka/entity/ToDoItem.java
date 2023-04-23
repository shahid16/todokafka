package com.infy.todokafka.entity;

import java.time.LocalDate;

import org.springframework.cglib.core.FieldTypeCustomizer;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonTypeName;
import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.couchbase.client.core.deps.com.google.protobuf.DescriptorProtos.FieldOptions;
import com.couchbase.client.core.deps.com.google.protobuf.FieldType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.cfg.EnumFeature;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document
public class ToDoItem {
	
	@Id
	@org.springframework.data.couchbase.core.mapping.id.GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	@Field(name = "task_id")
	private Long taskId;
	@Field(name = "task_name")
	private String taskName;
	@Field(name = "expected_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate expectedDate;
	@Field
	@JsonProperty("priority")
	private Priority priority;
	

	public Long getTaskId() {
		return taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public LocalDate getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Object obj) {
		this.priority = Priority.get(obj);
	}	

}
