/*
 * package com.pumakuki.rest.webservices.restfulwebservices.todo;
 * 
 * import java.net.URI; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.servlet.support.ServletUriComponentsBuilder;
 * 
 * @RestController
 * 
 * @CrossOrigin(origins = "http://localhost:4200") public class TodoJpaResource
 * {
 * 
 * @Autowired private TodoServiceImpl todoService;
 * 
 * @Autowired private TodoJpaRepository todoJpaRepository;
 * 
 * @GetMapping(path="/jpa/users/{username}/todos") public List<Todo>
 * getAllTodos(@PathVariable String username){
 * 
 * return todoJpaRepository.findByUsername(username);
 * 
 * //return todoService.findAll(); }
 * 
 * @GetMapping(path="/jpa/users/{username}/todos/{id}") public Todo
 * getTodoById(@PathVariable String username,@PathVariable long id){ return
 * todoJpaRepository.findById(id).get(); //return todoService.findById(id); }
 * 
 * @PutMapping(path="/jpa/users/{username}/todos/{id}") public
 * ResponseEntity<Todo> updateTodoById(@PathVariable String
 * username,@PathVariable long id,@RequestBody Todo todo){
 * todo.setUsername(username); Todo updatedTodo = todoJpaRepository.save(todo);
 * return new ResponseEntity<Todo>(updatedTodo,HttpStatus.OK); }
 * 
 * @PostMapping(path="/jpa/users/{username}/todos") public ResponseEntity<Void>
 * createTodoById(@PathVariable String username,@RequestBody Todo todo){
 * todo.setUsername(username); Todo createdTodo = todoJpaRepository.save(todo);
 * // Todo createdTodo = todoService.save(todo); URI uri =
 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
 * (createdTodo.getId()).toUri(); return ResponseEntity.created(uri).build();
 * 
 * }
 * 
 * @DeleteMapping("/jpa/users/{username}/todos/{id}") public
 * ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable
 * long id){
 * 
 * todoJpaRepository.deleteById(id); return ResponseEntity.noContent().build();
 * }
 * 
 * 
 * }
 */