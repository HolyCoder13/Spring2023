package io.gitub.mat3e.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
public interface TaskRepository {
    List<Task> findAll();
    Page<Task> findAll(Pageable page);
    Optional<Task> findById(Integer i);

    boolean existsById(Integer id);

    boolean existsByDoneIsFalseAndGroup_id(Integer groupId);
    List<Task> findByDone(boolean done);
    Task save(Task entity);
   // Page<Task> findAll(org.springframework.data.domain.Pageable page);
}
