package com.leanne.tgbl.rest.controller;

import com.leanne.tgbl.exceptions.ResourceNotFoundException;
import com.leanne.tgbl.rest.domain.RestTodo;
import com.leanne.tgbl.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.ACCEPTED;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the great bucket list!";
    }

    @GetMapping("/todos")
    public List<RestTodo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/todos/{id}")
    public RestTodo getTodoById(@PathVariable long id) {
        return todoService.getTodoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("todo", id));
    }

    @PostMapping("/todos")
    public ResponseEntity<RestTodo> createTodo(@RequestBody RestTodo restTodo) {
        RestTodo createdTodo = todoService.createTodo(restTodo);

        return new ResponseEntity<>(createdTodo, CREATED);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<RestTodo> updateTodo(@PathVariable long id, @RequestBody RestTodo restTodo) {
        RestTodo updatedTodo = todoService.updateTodo(id, restTodo);

        return new ResponseEntity<>(updatedTodo, ACCEPTED);
    }

    @DeleteMapping("todos/{id}")
    public void deleteTodo(@PathVariable long id) {
        todoService.deleteTodo(id);
    }
}
