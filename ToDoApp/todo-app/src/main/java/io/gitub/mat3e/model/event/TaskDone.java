package io.gitub.mat3e.model.event;

import io.gitub.mat3e.model.Task;

import java.time.Clock;

public class TaskDone extends TaskEvent {
    TaskDone(Task source) {
        super(source.getId(), Clock.systemDefaultZone());
    }
}
