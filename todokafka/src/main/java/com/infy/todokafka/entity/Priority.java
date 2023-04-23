package com.infy.todokafka.entity;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

@JsonFormat(shape = Shape.STRING)
public enum Priority {

	HIGH(1), MEDIUM(2), LOW(3);

	private int value;

	private Priority(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	
	  @JsonCreator public static Priority of(int priority) {
	  
	  return Stream.of(Priority.values()) .filter(p -> p.getValue() == priority)
	  .findFirst() .orElseThrow(IllegalArgumentException::new);
	  
	  }
	 
	@JsonCreator
	public static Priority get(Object reference) {
		if (reference instanceof Number num) {
			return of(num.intValue());
		} else if (reference instanceof String str) {
			// the string might contain the id as well, e.g. "21" for ACTIVE
			// so you might want to check the string for this, if this is expected
			return Enum.valueOf(Priority.class, str);
		}

		return null;
	}

}
