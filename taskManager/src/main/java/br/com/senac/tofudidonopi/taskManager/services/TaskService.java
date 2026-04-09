package br.com.senac.tofudidonopi.taskManager.services;

import br.com.senac.tofudidonopi.taskManager.domain.entities.Task;
import br.com.senac.tofudidonopi.taskManager.domain.entities.TaskPriority;
import br.com.senac.tofudidonopi.taskManager.domain.entities.TaskStatus;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAllByOrderByDueDateAsc(TaskPriority priority);

    List<Task> findAllByStatusOrderByDueDate(TaskStatus taskStatus);

    List<Task> findAll();

    List<Task> findAll(Pageable pageable);

    List<Task> findAllByExample(Task task);

    Optional<Task> findById(Long id);

    boolean existsById(long id);

    Long countEntities();

    void deleteById(Long id);

    void delete(Task task);

    List<Task> save(List<Task> task);

    Task update(Task task);
}
