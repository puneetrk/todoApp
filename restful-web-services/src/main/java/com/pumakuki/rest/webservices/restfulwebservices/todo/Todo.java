package com.pumakuki.rest.webservices.restfulwebservices.todo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String description;
	private String label;
	private Date targetDate;
	private String taskStatus;
	
	public Todo(){
		
	}
	
	public Todo(long id, String username, String description,String label, Date target,
			String taskStatus) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.label=label;
		this.targetDate = target;
		this.taskStatus = taskStatus;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date target) {
		this.targetDate = target;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String status) {
		this.taskStatus = status;
	}
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
