package com.leanne.tgbl.rest.domain;

import com.leanne.tgbl.repository.domain.RepoTodo;

public record RestTodo(long id, String name, boolean completed) {
    public static RepoTodo toRepoTodo(RestTodo restTodo) {
        return RepoTodo.builder()
                .id(restTodo.id())
                .name(restTodo.name())
                .completed(restTodo.completed())
                .build();
    }
}
