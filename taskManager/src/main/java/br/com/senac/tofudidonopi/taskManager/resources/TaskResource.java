package br.com.senac.tofudidonopi.taskManager.resources;


import br.com.senac.tofudidonopi.taskManager.domain.entities.Task;
import br.com.senac.tofudidonopi.taskManager.resources.dtos.TaskDTO;
import br.com.senac.tofudidonopi.taskManager.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//http://localhost:8080/api/tasks
@RestController
@RequestMapping ("api/tasks")
@RequiredArgsConstructor
public class TaskResource {

    private final TaskService taskService;
    @GetMapping ("/{id}")
    public ResponseEntity<TaskDTO> fetchById(@PathVariable Long id){
        Optional<Task> taskOp =
                this.taskService.findById(id);
        return taskOp.map(
                task ->
                        ResponseEntity.ok(
                                TaskDTO.fromEntity(task)
                        )
        ).orElseGet(
                ()-> ResponseEntity.notFound().build()
        );


    }
}
