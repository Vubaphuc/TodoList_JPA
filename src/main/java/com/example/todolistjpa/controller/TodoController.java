package com.example.todolistjpa.controller;


import com.example.todolistjpa.entity.Todo;
import com.example.todolistjpa.entity.request.CreateTodoRequest;
import com.example.todolistjpa.entity.request.UpdateTodoRequest;
import com.example.todolistjpa.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TodoController {

    @Autowired
    private TodoService service;


    // lấy all todolist
    @GetMapping("todos")
    public List<Todo> findAllTodos (){
        return service.findAllTodos();
    }

    // lấy todo theo id
    @GetMapping("todos/{id}")
    public ResponseEntity<?> findTodoById(@PathVariable Integer id) {
        Todo todo = service.findTodoById(id);
        return ResponseEntity.ok(todo);
    }


    // tạo mới todo
    @PostMapping("todos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createTodo(@RequestBody CreateTodoRequest request) {
        Todo todo = service.createTodo(request);

        return ResponseEntity.ok(todo);
    }

    // sửa todo
    @PutMapping("todos/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Integer id, @RequestBody UpdateTodoRequest request) {
        Todo todo = service.updateTodo(id, request);

        return ResponseEntity.ok(todo);
    }

    // xóa todo
    @DeleteMapping("todos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable Integer id) {
        service.deleteTodo(id);
    }
}
