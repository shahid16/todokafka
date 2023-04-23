package com.infy.todokafka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import com.infy.todokafka.entity.Priority;

@Configuration
public class CouchConfig  extends AbstractCouchbaseConfiguration{

	@Override
	public String getConnectionString() {
		return "couchbase://127.0.0.1";
	}

	@Override
	public String getUserName() {
		return "Admin";
	}

	@Override
	public String getPassword() {
		return "password";
	}

	@Override
	public String getBucketName() {
		return "todo";
	}
	
	@Override
	protected boolean autoIndexCreation() {
	 return true;
	}

}
