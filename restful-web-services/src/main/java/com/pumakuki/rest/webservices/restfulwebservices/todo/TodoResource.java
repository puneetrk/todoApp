package com.pumakuki.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

	@Autowired
	private TodoServiceImpl todoService;

	@GetMapping(path="/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoService.findAll();
	}
	
	@GetMapping(path="/users/{username}/todos/{id}")
	public Todo getTodoById(@PathVariable String username,@PathVariable long id){
		return todoService.findById(id);
	}
	
	@PutMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodoById(@PathVariable String username,@PathVariable long id,@RequestBody Todo todo){
		Todo updatedTodo = todoService.save(todo);
		return new ResponseEntity<Todo>(updatedTodo,HttpStatus.OK);
	}
	
	@PostMapping(path="/users/{username}/todos")
	public ResponseEntity<Void> createTodoById(@PathVariable String username,@RequestBody Todo todo){
		Todo createdTodo = todoService.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable long id){
		
		Todo todo = todoService.deleteById(id);
		if(todo!=null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
	
	
}
