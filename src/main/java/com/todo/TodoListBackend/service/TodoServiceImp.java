package com.todo.TodoListBackend.service;

import com.todo.TodoListBackend.model.Todo;
import com.todo.TodoListBackend.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

@Transactional
@Service
public class TodoServiceImp implements  TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) {
       if(todoRepository.existsById(id)){
           todoRepository.deleteById(id);
       }
       else{
           throw new RuntimeException("Todo not found with id: "+id);
       }
    }

    @Override
    public Todo updateTodo(Long id, Todo todo) {
        Optional<Todo> savedTodo = todoRepository.findById(id);

        if(savedTodo.isPresent()){
            Todo existingTodo = savedTodo.get();
            existingTodo.setCompleted(todo.isCompleted());
            existingTodo.setTitle(todo.getTitle());
            return todoRepository.save(existingTodo);
        }
        else{
            throw new RuntimeException("Todo not found with id:"+id);
        }
    }



}
