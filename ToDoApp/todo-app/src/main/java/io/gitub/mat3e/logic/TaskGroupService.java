package io.gitub.mat3e.logic;


import io.gitub.mat3e.TaskConfigurationProperties;
import io.gitub.mat3e.model.Project;
import io.gitub.mat3e.model.TaskGroup;
import io.gitub.mat3e.model.TaskGroupRepository;
import io.gitub.mat3e.model.TaskRepository;
import io.gitub.mat3e.model.projection.GroupReadModel;
import io.gitub.mat3e.model.projection.GroupWriteModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

//@Service
//@RequestScope
public class TaskGroupService {
    private static final Logger logger = LoggerFactory.getLogger(TaskGroupService.class);
    private TaskGroupRepository repository;
    private TaskRepository taskRepository;
    public TaskGroupService(TaskGroupRepository repository, TaskRepository taskRepository) {
        this.repository = repository;
        this.taskRepository = taskRepository;
    }
    public GroupReadModel createGroup(GroupWriteModel source){
        return createGroup(source,null);
    }
    public GroupReadModel createGroup(GroupWriteModel source, Project project) {
        TaskGroup result = repository.save(source.toGroup(project));
        return new GroupReadModel(result);
    }

    public List<GroupReadModel> readAll(){
        return repository.findAll()
                .stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(int groupId){
        if(taskRepository.existsByDoneIsFalseAndGroup_Id(groupId)){
            throw new IllegalStateException("Group has Un-done tasks!");
        }
        TaskGroup result = repository.findById(groupId)
                .orElseThrow(()->new IllegalArgumentException("Task group with given id not found"));
    result.setDone(!result.isDone());
    repository.save(result);
    }

    @Async
    public CompletableFuture<List<TaskGroup>> findAllAsync(){
        logger.info("Suply A-sync on TaskGroup");
        return CompletableFuture.supplyAsync(repository::findAll);
    }


}
