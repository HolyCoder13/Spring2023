package io.gitub.mat3e.aspect;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogicAspect {
    public static final Logger logger = LoggerFactory.getLogger(LogicAspect.class);
    private final Timer projectCreateGroupTimer;
    LogicAspect(final MeterRegistry registry){
        projectCreateGroupTimer = registry.timer("logic.project.create.group");
    }
    @Pointcut("execution (* io.gitub.mat3e.logic.ProjectService.createGroup(..))")
    static void projectServiceCreateGroup(){
    }
    @Before("projectServiceCreateGroup()")
    void logMethodCall(JoinPoint jp){
        logger.info("Before {} with {}",jp.getSignature().getName());
    }
    @Around("projectServiceCreateGroup()")
    Object aroundProjectCreateGroup(ProceedingJoinPoint jp){
        return projectCreateGroupTimer.record(()->{
            try{
                return  jp.proceed();
            }catch (Throwable e){
                if ( e instanceof RuntimeException){
                    throw (RuntimeException ) e;
                }
                throw new RuntimeException(e);
            }
        });



    }
}
