package io.gitub.mat3e.reports;

import io.gitub.mat3e.model.event.TaskDone;
import io.gitub.mat3e.model.event.TaskEvent;
import io.gitub.mat3e.model.event.TaskUndone;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
public class ChangedTaskEventListener {
    private static final Logger logger = LoggerFactory.getLogger(ChangedTaskEventListener.class);
    private final PersistedTaskEventRepository repository;

    public ChangedTaskEventListener(PersistedTaskEventRepository repository) {
        this.repository = repository;
    }

    @Async
    @EventListener
    public void on(TaskDone event){
        onChanged(event);
    }


    @Async
    @EventListener
    public void on(TaskUndone event){
        logger.info("Got"+event);
        onChanged(event);
        
    }
    private void onChanged(final TaskEvent event) {
        logger.info("Got"+ event);
        repository.save(new PersistedTaskEvent(event));
    }
}
