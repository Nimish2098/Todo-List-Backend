package com.todo.TodoListBackend.repository;

import com.todo.TodoListBackend.model.Todo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo,Long> {

    @Override
    List<Todo> findAll(Sort sort);

    @Override
    <S extends Todo> S save(S entity);

    @Override
    Optional<Todo> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
