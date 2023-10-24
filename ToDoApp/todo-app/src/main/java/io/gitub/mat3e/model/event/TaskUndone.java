package io.gitub.mat3e.model.event;

import io.gitub.mat3e.model.Task;

import java.time.Clock;

public class TaskUndone extends TaskEvent {
    TaskUndone(Task source) {
        super(source.getId(), Clock.systemDefaultZone());
    }
}
