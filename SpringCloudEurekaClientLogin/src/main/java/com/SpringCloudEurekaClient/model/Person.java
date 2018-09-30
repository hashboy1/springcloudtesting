package com.SpringCloudEurekaClient.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="personal")
@PropertySource("classpath:personaldefine.properties")

public class Person {

	 private long id;
	 private String name;
	 
	 public long getId()
	 {
		 return id;
		 
	 }
	 
	 public void setId(long id)
	 {
		 this.id=id;
	 }
	 
	 public String getName()
	 {
		 return name;
		 
	 }
	 
	 public void setName(String name)
	 {
		 this.name=name;
	 }

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	 
	 
	 
}
