package com.todo.TodoListBackend.controller;


import com.todo.TodoListBackend.model.Todo;
import com.todo.TodoListBackend.repository.TodoRepository;
import com.todo.TodoListBackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    private TodoRepository todoRepository;

    @GetMapping("/api/todos")
    public List<Todo> getAllTasks() {
        return todoRepository.findAll();
    }

    @PostMapping("/api/todos")
    public Todo createTask(@RequestBody Todo task) {
        return todoRepository.save(task);
    }

    @PutMapping("/api/{id}")
    public Todo updateTask(@PathVariable Long id, @RequestBody Todo todoDetails) {
       Todo task = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        task.setCompleted(todoDetails.isCompleted());
        return todoRepository.save(task);
    }

    @DeleteMapping("/api/todos/{id}")
    public void deleteTask(@PathVariable Long id){
        Todo task = todoRepository.findById(id)
                .orElseThrow(()->new RuntimeException(("Not Found")));
        todoRepository.delete(task);
    }
}
