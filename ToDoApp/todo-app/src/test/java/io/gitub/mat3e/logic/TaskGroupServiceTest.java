package io.gitub.mat3e.logic;

import io.gitub.mat3e.model.TaskGroup;
import io.gitub.mat3e.model.TaskGroupRepository;
import io.gitub.mat3e.model.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaskGroupServiceTest {
    @Test
    @DisplayName("should throw when undone tasks")
    void toggleGroup_throws_undoneTask_IllegalStateException(){

        TaskRepository mockTaskRepository = taskRepositoryReturning(true);

        var toTest = new TaskGroupService(null,mockTaskRepository);
        var exception = catchThrowable(()->toTest.toggleGroup(1));
        assertThat(exception)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Un-done tasks!");
    }
    @Test
    @DisplayName("should throw when no group")
    void toggleGroup_wrongId_throwsIllegalArgumentException(){
        TaskRepository mockTaskRepository = taskRepositoryReturning(false);
        var mockRepository = mock(TaskGroupRepository.class);
        when(mockRepository.findById(anyInt())).thenReturn(Optional.empty());

        var toTest = new TaskGroupService(mockRepository,mockTaskRepository);

        var exception = catchThrowable(()->toTest.toggleGroup(1));

        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("id not found");

    }

    @Test
    @DisplayName("should toggle group")
    void toggleGroup_worksAsExpected(){
        TaskRepository mockTaskRepository = taskRepositoryReturning(false);
        var group = new TaskGroup();
        var beforeToggle = group.isDone();

        var mockRepository = mock(TaskGroupRepository.class);
        when(mockRepository.findById(anyInt())).thenReturn(Optional.of(group));

        var toTest = new TaskGroupService(mockRepository,mockTaskRepository);

        toTest.toggleGroup(0);
        assertThat(group.isDone()).isEqualTo(!beforeToggle);

    }
    private TaskRepository taskRepositoryReturning(final boolean result){
        var mockTaskRepository = mock(TaskRepository.class);
        when(mockTaskRepository.existsByDoneIsFalseAndGroup_Id(anyInt())).thenReturn(result);
        return mockTaskRepository;
    }



}