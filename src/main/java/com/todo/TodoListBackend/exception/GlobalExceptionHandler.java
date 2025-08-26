package com.todo.TodoListBackend.exception;

import com.todo.TodoListBackend.service.TodoServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(TodoServiceImp.ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(TodoServiceImp.ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
