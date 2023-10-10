package io.gitub.mat3e.logic;

import io.gitub.mat3e.TaskConfigurationProperties;
import io.gitub.mat3e.model.*;
import io.gitub.mat3e.model.projection.GroupReadModel;
import io.gitub.mat3e.model.projection.GroupTaskWriteModel;
import io.gitub.mat3e.model.projection.GroupWriteModel;
import io.gitub.mat3e.model.projection.ProjectWriteModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

//@Service

public class ProjectService {
    private ProjectRepository repository;
    private TaskGroupRepository taskGroupRepository;
    private TaskGroupService taskGroupService;
    private TaskConfigurationProperties config;

    public ProjectService(ProjectRepository repository, TaskGroupRepository taskGroupRepository, TaskGroupService taskGroupService, TaskConfigurationProperties config) {
        this.repository = repository;
        this.taskGroupRepository = taskGroupRepository;
        this.taskGroupService = taskGroupService;
        this.config = config;
    }

    public List<Project> readAll(){
        return repository.findAll();
    }
    public Project save(ProjectWriteModel toSave){
        return repository.save(toSave.toProject());
    }

    public GroupReadModel createGroup(LocalDateTime deadline, int projectId){
        if(!config.getTemplate().isAllowMultipleTasks()&&taskGroupRepository.existsByDoneIsFalseAndProject_Id(projectId)){
            throw new IllegalStateException("Only one undone group from project is allowed!");
        }
        GroupReadModel result = repository.findById(projectId)
                .map(project -> {
                    var targetGroup = new GroupWriteModel();
                    targetGroup.setDescription(project.getDescription());
                    targetGroup.setTasks(
                            (List<GroupTaskWriteModel>) project.getSteps().stream()
                                    .map(projectStep -> {
                                        var task = new GroupTaskWriteModel();
                                        task.setDescription(projectStep.getDescription());
                                        task.setDeadline(deadline.plusDays(projectStep.getDaysToDeadline()));
                                        return task;
                                    }
                                    ).collect(Collectors.toSet())
                    );
                    return taskGroupService.createGroup(targetGroup,project);
                }).orElseThrow(()-> new IllegalArgumentException("Project with given id not found!"));
        return result;
    }


}
