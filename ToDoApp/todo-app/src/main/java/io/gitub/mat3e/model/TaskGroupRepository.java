package io.gitub.mat3e.model;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface TaskGroupRepository {
    List<TaskGroup> findAll();
    Optional<TaskGroup> findById(Integer id);
    TaskGroup save(TaskGroup entity);
    boolean existsByDoneIsFalseAndProject_Id(Integer projectId);
}
