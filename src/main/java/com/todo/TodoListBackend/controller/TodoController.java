package com.todo.TodoListBackend.controller;


import com.todo.TodoListBackend.model.Todo;
import com.todo.TodoListBackend.repository.TodoRepository;
import com.todo.TodoListBackend.service.TodoService;
import com.todo.TodoListBackend.service.TodoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

//    @Autowired
//    private TodoService todoService;
//
//    @GetMapping("/api/todos")
//    public List<Todo> getAllTodos(){
//        return todoService.getAllTodos();
//    }
//
//    @PostMapping("/api/todos")
//    public String createTodo(@RequestBody Todo todo){
//        todoService.createTodo(todo);
//        return "CreatedSuccesfully";
//    }
//
//    @PutMapping("/{id}")
//    public String updateTodo(@PathVariable Long id,@RequestBody Todo todo){
//        String savedTodo = todoService.updateTodo(id,todo);
//        return "Todo updated successfully";
//    }
//
//    @DeleteMapping("/todos/{id}")
//    public String deleteTodo(@PathVariable Long id){
//        todoService.deleteTodo(id);
//        return "Deleted Successfully";
//    }
    @Autowired
    private TodoServiceImp todoServiceImp;

    @GetMapping
    public List<Todo> getAllTasks() {

        return todoServiceImp.getAllTodos();
    }

    @PostMapping
    public ResponseEntity<Todo> createTask(@RequestBody Todo task) {
        Todo newTodo = todoServiceImp.createTodo(task);
        return new ResponseEntity<Todo>(newTodo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTask(@PathVariable Long id, @RequestBody Todo todoDetails) {
       Todo task = todoServiceImp.updateTodo(id,todoDetails);
        return new ResponseEntity<>(task,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        todoServiceImp.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
