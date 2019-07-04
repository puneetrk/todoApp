package com.pumakuki.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static long idCounter =1;
	
	
	public List<Todo> findAll(){
		return todos;
	}
	
	
	public Todo deleteById(long id){
		Todo todo = findById(id);
		if(todo==null)
			return null;
		if(todos.remove(todo))
			return todo;
		return null;
		
	}
	public Todo findById(long id) {
		
		for(Todo todo : todos){
			if(todo.getId()==id)
				return todo;
		}
		return null;
	}
	
	public Todo save(Todo todo){
		
		if(todo.getId()==-1 || todo.getId()==0)
		{
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else
		{
			deleteById(todo.getId());
			todo.setId(++idCounter);
			todos.add(todo);
		}
		return todo;
		
	}


	public boolean deleteTodoForUser(String user_id) {
		// TODO Auto-generated method stub
		return false;
	}

	public void updateUserTodo(String user_id, Todos todo) {
		// TODO Auto-generated method stub
		
	}

	public void createUserTodo(Todos todo) {
		// TODO Auto-generated method stub
		
	}

	
}
