package io.gitub.mat3e.reports;

import io.gitub.mat3e.model.event.TaskEvent;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "task_events")
public class PersistedTaskEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int taskId;
    String name;
    LocalDateTime occurence;
     public PersistedTaskEvent(){};
     PersistedTaskEvent(TaskEvent source){
         taskId=source.getTaskId();
         name=source.getClass().getSimpleName();
         occurence=LocalDateTime.ofInstant(source.getOccurence(), ZoneId.systemDefault());
     }

}
