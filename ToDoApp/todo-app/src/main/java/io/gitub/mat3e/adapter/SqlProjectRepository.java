package io.gitub.mat3e.adapter;

import io.gitub.mat3e.model.Project;
import io.gitub.mat3e.model.ProjectRepository;
import io.gitub.mat3e.model.TaskGroup;
import io.gitub.mat3e.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlProjectRepository extends ProjectRepository,JpaRepository<Project,Integer> {
    @Override
    @Query("select distinct p from Project p join fetch p.steps")
    List<Project> findAll();

}
