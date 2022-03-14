package com.leanne.tgbl.repository;

import com.leanne.tgbl.repository.domain.RepoTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<RepoTodo, Long> {
}
