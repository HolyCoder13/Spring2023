package io.gitub.mat3e.model.projection;

import io.gitub.mat3e.model.Project;
import io.gitub.mat3e.model.ProjectStep;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProjectWriteModel {
    @NotBlank(message = "Project step description cannot be empty!")
    private String description;
    @Valid
    private List<ProjectStep> steps = new ArrayList<>();
    public ProjectWriteModel(){
        steps.add(new ProjectStep());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProjectStep> getSteps() {
        return steps;
    }

    public void setSteps(List<ProjectStep> steps) {
        this.steps = steps;
    }
    public Project toProject(){
        var result = new Project();
        result.setDescription(description);
        steps.forEach(step->step.setProject(result));
        result.setSteps(new HashSet<>(steps));
        return result;
    }
}
