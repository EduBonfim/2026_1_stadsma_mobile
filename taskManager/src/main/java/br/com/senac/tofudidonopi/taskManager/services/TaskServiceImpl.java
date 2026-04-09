package br.com.senac.tofudidonopi.taskManager.services;


import br.com.senac.tofudidonopi.taskManager.datasource.repositores.TaskRepository;
import br.com.senac.tofudidonopi.taskManager.domain.entities.Task;
import br.com.senac.tofudidonopi.taskManager.domain.entities.TaskPriority;
import br.com.senac.tofudidonopi.taskManager.domain.entities.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Task> findAllByOrderByDueDateAsc(TaskPriority priority){
        return this.taskRepository.findAllByPriorityOrderByDueDateAsc(priority);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Task> findAllByStatusOrderByDueDate(TaskStatus taskStatus){
        return this.taskRepository.findAllByStatusOrderByDueDateAsc(taskStatus);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Task> findAll(){
        return this.taskRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Task> findAll(Pageable pageable){
        return List.of();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Task> findAllByExample(Task task){
        return this.taskRepository.findAll(Example.of(task));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Optional<Task> findById(Long id) {
        return this.taskRepository.findById(id);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean existsById(long id){
        return this.taskRepository.existsById(id);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long countEntities(){
        return this.taskRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id){
        this.taskRepository.deleteById(id);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Task task){
        this.taskRepository.delete(task);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Task> save(List<Task> task){
        return this.taskRepository.saveAll(task);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Task update(Task task){
        return this.taskRepository.save(task);
    }
}
