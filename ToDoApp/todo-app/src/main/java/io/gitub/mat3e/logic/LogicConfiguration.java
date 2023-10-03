package io.gitub.mat3e.logic;

import io.gitub.mat3e.TaskConfigurationProperties;
import io.gitub.mat3e.model.ProjectRepository;
import io.gitub.mat3e.model.TaskGroupRepository;
import io.gitub.mat3e.model.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogicConfiguration {
    @Bean
    ProjectService projectService(
            ProjectRepository repository,
            TaskGroupRepository taskGroupRepository,
            TaskGroupService taskGroupService,
            TaskConfigurationProperties config
    ){
        return  new ProjectService(repository,taskGroupRepository, taskGroupService, config);
    }

    @Bean
    TaskGroupService taskGroupService(
            final TaskGroupRepository taskGroupRepository,
            final TaskRepository taskRepository
    ) {
        return new TaskGroupService(taskGroupRepository,taskRepository);
    }
}
