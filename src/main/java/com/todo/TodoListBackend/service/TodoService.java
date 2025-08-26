package com.todo.TodoListBackend.service;

import com.todo.TodoListBackend.model.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getAllTodos();
    public Todo createTodo(Todo todo);
    public void deleteTodo(Long id);
    public Todo updateTodo(Long id,Todo todo);
}
