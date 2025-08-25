package com.todo.TodoListBackend.service;

import com.todo.TodoListBackend.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImp implements  TodoService{

    private List<Todo> todoList = new ArrayList<>();
    private Long todoId = 1L;
    public TodoServiceImp() {
        super();
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoList;
    }

    @Override
    public String createTodo(Todo todo) {
        todo.setId(todoId++);
        
        todoList.add(todo);
        return "Task Addded Succesfully";
    }

    @Override
    public String deleteTodo(Long id) {
        Todo todo = todoList.stream().filter(c ->c.getId().equals(id)).findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        todoList.remove(todo);
        return "Deleted Successfully";
    }

    @Override
    public String updateTodo(Long id, Todo todo) {
        Optional<Todo>savedTodo = todoList.stream().filter(c->c.getId().equals(id)).findFirst();
        if(savedTodo.isPresent()){
            Todo existingTodo = savedTodo.get();
            existingTodo.setCompleted(todo.isCompleted());
            return "Updated Succesfully";
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found");
        }

    }
}
