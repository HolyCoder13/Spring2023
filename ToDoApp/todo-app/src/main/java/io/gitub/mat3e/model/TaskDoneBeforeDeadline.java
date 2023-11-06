package io.gitub.mat3e.model;

import java.util.ArrayList;
import java.util.List;

public class TaskDoneBeforeDeadline extends Task{

List<Task> metDeadline;
    public TaskDoneBeforeDeadline(Task task) {
        super(task.getDescription(),task.getDeadline());
        metDeadline = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "TaskDoneBeforeDeadline{" +
                "metDeadline=" + metDeadline +
                '}';
    }
}
