package io.gitub.mat3e.reports;

import io.gitub.mat3e.model.event.TaskDone;
import io.gitub.mat3e.model.event.TaskUndone;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
public class ChangedTaskEventListener {
    private static final Logger logger = LoggerFactory.getLogger(ChangedTaskEventListener.class);
    @EventListener
    public void on(TaskDone event){
        logger.info("Got"+event);
    }
    @EventListener
    public void on(TaskUndone event){
        logger.info("Got"+event);
    }

}
