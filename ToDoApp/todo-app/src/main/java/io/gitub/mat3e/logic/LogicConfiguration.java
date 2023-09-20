package io.gitub.mat3e.logic;

import io.gitub.mat3e.TaskConfigurationProperties;
import io.gitub.mat3e.model.ProjectRepository;
import io.gitub.mat3e.model.TaskGroupRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogicConfiguration {
    @Bean
    ProjectService service(
            ProjectRepository repository,
            TaskGroupRepository taskGroupRepository,
            TaskConfigurationProperties config
    ){
        return  new ProjectService(repository,taskGroupRepository,config);
    }
}
