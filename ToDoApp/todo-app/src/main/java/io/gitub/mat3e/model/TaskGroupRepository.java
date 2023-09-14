package io.gitub.mat3e.model;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface TaskGroupRepository {
    List<TaskGroup> findAll();
    //Page<Task> findAll(Pageable page);
    Optional<TaskGroup> findById(Integer id);
   // boolean existsById(Integer id);
   // boolean existsByDoneIsFalseAndGroup_id(Integer groupId);
   // List<Task> findByDone(boolean done);
    TaskGroup save(TaskGroup entity);
}
