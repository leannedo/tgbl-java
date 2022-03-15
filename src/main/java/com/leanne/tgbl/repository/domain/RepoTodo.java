package com.leanne.tgbl.repository.domain;

import com.leanne.tgbl.rest.domain.RestTodo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "todos")
public class RepoTodo {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "completed")
    public boolean completed;

    @Column(name = "created_at")
    public LocalDateTime createdAt;

    @Column(name = "updated_at")
    public LocalDateTime updatedAt;

    public static RestTodo toRestTodo(RepoTodo repoTodo) {
        return new RestTodo(repoTodo.getId(), repoTodo.getName(), repoTodo.isCompleted());
    }
}
