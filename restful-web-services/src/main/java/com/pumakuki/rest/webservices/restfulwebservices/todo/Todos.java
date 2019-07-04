package com.pumakuki.rest.webservices.restfulwebservices.todo;

import java.util.Date;

public class Todos {
	
	Long todo_id;
	String description;
	boolean isCompleted;
	Date target_date;
	
	public Long getTodo_id() {
		return todo_id;
	}
	public void setTodo_id(Long todo_id) {
		this.todo_id = todo_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public Date getTarget_date() {
		return target_date;
	}
	public void setTarget_date(Date target_date) {
		this.target_date = target_date;
	}


}
