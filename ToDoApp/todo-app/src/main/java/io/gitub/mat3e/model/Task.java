package io.gitub.mat3e.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Description cannot be null!")
    private String description;
    private boolean done;
    private LocalDateTime deadline;
    @Embedded
    private Audit audit = new Audit();
    @ManyToOne
    @JoinColumn(name = "task_group_id")
    private TaskGroup group;
    public Task() {

    }
    public Task(String description, LocalDateTime deadLine){
        this(description,deadLine,null);

    }

    public Task(String description, LocalDateTime deadLine, TaskGroup group){
        this.description=description;
        this.deadline=deadLine;
        if(group != null){
            this.group=group;
        }

    }

    public int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="done")
    public boolean isDone(){
        return done;
    }

    public void setDone(final boolean done){
        this.done=done;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadLine) {
        this.deadline = deadLine;
    }
    TaskGroup getGroup() {
        return group;
    }

    void setGroup(final TaskGroup group) {
        this.group = group;
    }

    public void updateFrom(final Task source){
        description = source.description;
        done=source.done;
        deadline = source.deadline;
        group = source.group;

    }


}
