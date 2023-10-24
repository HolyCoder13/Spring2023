package io.gitub.mat3e.controller;

import io.gitub.mat3e.logic.TaskService;
import io.gitub.mat3e.model.Task;
import io.gitub.mat3e.model.TaskRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.awt.print.Pageable;

import java.net.URI;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final ApplicationEventPublisher eventPublisher;
    private final TaskRepository repository;
    private final TaskService service;


    TaskController(ApplicationEventPublisher eventPublisher, final TaskRepository repository, TaskService service) {
        this.eventPublisher = eventPublisher;
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    ResponseEntity<Task> createTask(@RequestBody @Valid Task toCreate){
        Task result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }
    @GetMapping(params = {"!sort","!page","!size"})
    CompletableFuture<ResponseEntity<List<Task>>> readAllTasks(){

        logger.warn("Exposing all the tasks");
        return service.findAllAsync().thenApply(ResponseEntity::ok);

    }

    @GetMapping
    ResponseEntity<List<Task>> readAllTasks(Pageable page){

        logger.info("Custom pageable");

        return  ResponseEntity.ok(repository.findAll(page).getContent());
    }
    @GetMapping("/{id}")
    ResponseEntity<Task> readTask(@PathVariable int id){
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/search/done")
    ResponseEntity<List<Task>> readDoneTasks(@RequestParam(defaultValue = "true") boolean state){
        return ResponseEntity.ok(
                repository.findByDone(state)
        );
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id,@RequestBody @Valid Task toUpdate){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(task -> {
                    task.updateFrom(toUpdate);
                    repository.save(task);
                });

        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<?> toggleTask(@PathVariable int id){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .map(Task::toggle)
                .ifPresent(eventPublisher::publishEvent);

        return ResponseEntity.noContent().build();
    }
    /*todo/
    hardcoded now date
    wywolanie
     */
    @GetMapping("/today")
    public ResponseEntity<?> searchTodayTasks(){
        return ResponseEntity.ok(service.findForTodayAndOverdue());
    }

}
