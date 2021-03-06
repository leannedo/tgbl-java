package com.leanne.tgbl.service;

import com.leanne.tgbl.rest.domain.RestTodo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    RestTodo createTodo(RestTodo restTodo);

    List<RestTodo> getAllTodos();

    Optional<RestTodo> getTodoById(long id);

    RestTodo updateTodo(long id, RestTodo todo);

    void deleteTodo(long id);
}
