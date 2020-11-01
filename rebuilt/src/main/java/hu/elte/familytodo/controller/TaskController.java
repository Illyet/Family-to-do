package hu.elte.familytodo.controller;

import hu.elte.familytodo.model.Message;
import hu.elte.familytodo.model.Task;
import hu.elte.familytodo.repository.MessageRepository;
import hu.elte.familytodo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository taskRepository;
    private MessageRepository messageRepository;

    public TaskController(@Autowired TaskRepository taskRepository, @Autowired MessageRepository messageRepository) {
        this.taskRepository = taskRepository;
        this.messageRepository = messageRepository;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Task>> getTasks(@RequestParam(required = false) String title) {
        Iterable<Task> tasks;
        if (title == null) {
            tasks = taskRepository.findAll();
        } else {
            tasks = taskRepository.findAllByTitleContains(title);
        }
        return ResponseEntity.ok(tasks);
    }
    @GetMapping("/{taskId}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Integer taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            return ResponseEntity.ok(optionalTask.get().getMessages());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Integer taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            return ResponseEntity.ok(optionalTask.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{taskId}/messages")
    public ResponseEntity<Message> postTaskMessage(@PathVariable Integer taskId, @RequestBody Message message) {
        Optional<Task> oTask = taskRepository.findById(taskId);
        if (oTask.isPresent()) {
            Task task = oTask.get();
            message.setTask(task);
            Message createdMessage = messageRepository.save(message);
            return ResponseEntity.ok(createdMessage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        task.setStatus(Task.Status.NEW);
        Task savedTask = taskRepository.save(task);
        return ResponseEntity.ok(savedTask);
    }
    
    
    @DeleteMapping("/{taskId}")
    public ResponseEntity deleteTask(@PathVariable Integer taskId){
        try {
            taskRepository.deleteById(taskId);
            return ResponseEntity.ok().build();
        }catch(EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> put(@RequestBody Task task, @PathVariable Integer id) {
        Optional<Task> oTask = taskRepository.findById(id);
        if (oTask.isPresent()) {
            task.setId(id);
            return ResponseEntity.ok(taskRepository.save(task));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
