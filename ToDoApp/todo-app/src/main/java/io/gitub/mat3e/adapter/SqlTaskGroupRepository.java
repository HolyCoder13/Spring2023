package io.gitub.mat3e.adapter;

import io.gitub.mat3e.model.TaskGroup;
import io.gitub.mat3e.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlTaskGroupRepository extends TaskGroupRepository,JpaRepository<TaskGroup,Integer> {

}
