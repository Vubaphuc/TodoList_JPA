package com.example.todolistjpa.service;

import com.example.todolistjpa.entity.Todo;
import com.example.todolistjpa.entity.request.CreateTodoRequest;
import com.example.todolistjpa.entity.request.UpdateTodoRequest;
import com.example.todolistjpa.exception.BadRequestException;
import com.example.todolistjpa.exception.NotFoundException;
import com.example.todolistjpa.repository.TodoRepository;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> findAllTodos() {
        return repository.findAll();
    }

    public Todo findTodoById(Integer id) {
        Todo todo = repository.findTodoById(id).orElseThrow(() -> {
           throw new NotFoundException("Not found Todo with id = " + id);
        });
        return todo;
    }

    public Todo createTodo(CreateTodoRequest request) {
        Todo todo = Todo.builder()
                .title(request.getTitle())
                .build();
        todo = repository.save(todo);
        return todo;
    }

    public void deleteTodo(Integer id) {
        Todo todo = repository.findTodoById(id).orElseThrow(() -> {
            throw new NotFoundException("Not Found todo with id = " + id);
        });
        repository.deleteById(todo.getId());
    }

    public Todo updateTodo(Integer id, UpdateTodoRequest request) {
        Todo todo = repository.findTodoById(id).orElseThrow(() -> {
            throw new NotFoundException("Not Found todo with id = " + id);
        });
        todo.setTitle(request.getTitle());
        todo.setStatus(request.isStatus());

        todo = repository.save(todo);
        return todo;
    }
}
