package com.todo.TodoListBackend.service;

import com.todo.TodoListBackend.model.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getAllTodos();
    public String createTodo(Todo todo);
    public String deleteTodo(Long id);
    public String updateTodo(Long id,Todo todo);
}
