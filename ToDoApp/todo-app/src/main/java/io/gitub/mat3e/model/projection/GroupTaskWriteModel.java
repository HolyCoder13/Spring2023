package io.gitub.mat3e.model.projection;

import io.gitub.mat3e.model.Task;
import io.gitub.mat3e.model.TaskGroup;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class GroupTaskWriteModel {
    @NotBlank(message = "Task's description cannot be null!")
    private String description;
    private LocalDateTime deadline;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Task toTask(TaskGroup group){
        return new Task(description,deadline,group);
    }
}
