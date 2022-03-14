package com.leanne.tgbl.rest.controller;

import com.leanne.tgbl.exceptions.ResourceNotFoundException;
import com.leanne.tgbl.rest.domain.RestTodo;
import com.leanne.tgbl.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.ACCEPTED;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoServiceImpl toDoService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the great bucket list!";
    }

    @GetMapping("/todos")
    public List<RestTodo> getAllTodos() {
        return toDoService.getAllTodos();
    }

    @GetMapping("/todos/{id}")
    public RestTodo getTodoById(@PathVariable long id) {
        return toDoService.getTodoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("todo", id));
    }

    @PostMapping("/todos")
    public ResponseEntity<RestTodo> createTodo(@RequestBody RestTodo restTodo) {
        final HttpHeaders responseHeaders = new HttpHeaders();
        RestTodo createdTodo = toDoService.createTodo(restTodo);
        responseHeaders.set("X-RestCollection-Url-key", Long.toString(createdTodo.id()));

        return new ResponseEntity<>(createdTodo, responseHeaders, CREATED);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<RestTodo> updateTodo(@PathVariable long id, @RequestBody RestTodo restTodo) {
        final HttpHeaders responseHeaders = new HttpHeaders();
        RestTodo updatedTodo = toDoService.updateTodo(id, restTodo);
        responseHeaders.set("X-RestCollection-Url-key", Long.toString(updatedTodo.id()));

        return new ResponseEntity<>(updatedTodo, responseHeaders, ACCEPTED);
    }

    @DeleteMapping("todos/{id}")
    public void deleteTodo(@PathVariable long id) {
        toDoService.deleteTodo(id);
    }
}
