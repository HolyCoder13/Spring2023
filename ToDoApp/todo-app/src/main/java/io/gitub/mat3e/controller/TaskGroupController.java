package io.gitub.mat3e.controller;

import io.gitub.mat3e.logic.TaskGroupService;
import io.gitub.mat3e.model.Task;
import io.gitub.mat3e.model.TaskGroup;
import io.gitub.mat3e.model.TaskGroupRepository;
import io.gitub.mat3e.model.TaskRepository;
import io.gitub.mat3e.model.projection.GroupReadModel;
import io.gitub.mat3e.model.projection.GroupWriteModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping("/groups")
public class TaskGroupController {
    private final Logger logger = LoggerFactory.getLogger(TaskGroupController.class);
    private final TaskRepository repository;
    private final TaskGroupService service;

    public TaskGroupController(TaskRepository repository, TaskGroupService service) {
        this.repository = repository;
        this.service = service;
    }
    //methods
    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GroupReadModel> createGroup(@RequestBody @Valid GroupWriteModel toCreate){
        GroupReadModel result = service.createGroup(toCreate);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }
//    @GetMapping
//    CompletableFuture<ResponseEntity<List<TaskGroup>>> readAllTaskGroups(){
//        logger.warn("Exposing all the Task Groups!");
//        return service.findAllAsync().thenApply(ResponseEntity::ok);
//    }
    @ResponseStatus
    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<GroupReadModel>> readAllGroups(){
        logger.info("Exposing taskGroups");
        return  ResponseEntity.ok(service.readAll());
    }
    @ResponseBody
    @GetMapping("/{id}")
    ResponseEntity<List<Task>> readAllTasksFromGroup(@PathVariable int id){
        return ResponseEntity.ok(repository.findAllByGroup_Id(id));
    }
    @Transactional
    @ResponseBody
    @PatchMapping("/{id}")
    public ResponseEntity<?> toggleTaskGroup(@PathVariable int id){
        service.toggleGroup(id);
               return ResponseEntity.noContent().build() ;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String>handledIllegalArgument(IllegalArgumentException e){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalStateException.class)
    ResponseEntity<String>handleIllegalState(IllegalStateException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
