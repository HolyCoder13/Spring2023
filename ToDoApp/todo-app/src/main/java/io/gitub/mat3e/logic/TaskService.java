package io.gitub.mat3e.logic;

import io.gitub.mat3e.model.Task;
import io.gitub.mat3e.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository repository;

    TaskService(final TaskRepository repository){
        this.repository = repository;
    }
    @Async
    public CompletableFuture<List<Task>> findAllAsync(){
        logger.info("Supply async!");
        return CompletableFuture.supplyAsync(repository::findAll);
    }

    public List<Task> findForTodayAndOverdue(){
        LocalDateTime today = LocalDateTime.now();
        return repository.findByDone(false).stream()
                .filter(task -> task.getDeadline().isBefore(today.plusDays(2)))
                .collect(Collectors.toList());

    }


}
