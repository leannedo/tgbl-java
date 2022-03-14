package com.leanne.tgbl.service;

import com.leanne.tgbl.exceptions.ResourceNotFoundException;
import com.leanne.tgbl.repository.TodoRepository;
import com.leanne.tgbl.repository.domain.RepoTodo;
import com.leanne.tgbl.rest.domain.RestTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository toDoRepository;

    public RestTodo createTodo(RestTodo restTodo) {
        RepoTodo repoToDo = toDoRepository.save(RestTodo.toRepoTodo(restTodo));
        return RepoTodo.toRestTodo(repoToDo);
    }

    public List<RestTodo> getAllTodos() {
        return toDoRepository.findAll().stream()
                .map(RepoTodo::toRestTodo)
                .toList();
    }

    public Optional<RestTodo> getTodoById(long id) {
        return toDoRepository.findById(id).map(RepoTodo::toRestTodo);
    }

    public RestTodo updateTodo(long id, RestTodo todo) {
        Optional<RepoTodo> toUpdate = toDoRepository.findById(id);
        if (toUpdate.isPresent()) {
            RepoTodo updatedTodo = RestTodo.toRepoTodo(todo);
            updatedTodo.setId(id);
            return RepoTodo.toRestTodo(toDoRepository.save(updatedTodo));
        }
        throw new ResourceNotFoundException("todo", id);
    }

    public void deleteTodo(long id) {
        Optional<RepoTodo> toUpdate = toDoRepository.findById(id);
        if (toUpdate.isPresent()) {
            toDoRepository.deleteById(id);
        }
        throw new ResourceNotFoundException("todo", id);
    }
}
