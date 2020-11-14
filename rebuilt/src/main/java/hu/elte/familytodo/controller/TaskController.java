package hu.elte.familytodo.controller;

import hu.elte.familytodo.model.Message;
import hu.elte.familytodo.model.Task;
import hu.elte.familytodo.model.User;
import hu.elte.familytodo.repository.MessageRepository;
import hu.elte.familytodo.repository.TaskRepository;
import hu.elte.familytodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping("")
    public ResponseEntity<Iterable<Task>> getTasks(@RequestParam(required = false) String title) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<String> roles = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        if (roles.contains("ROLE_ADMIN")) {
            return ResponseEntity.ok(taskRepository.findAll());
        }
        String username = auth.getName();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getTasks());
        }
        return ResponseEntity.notFound().build();
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @GetMapping("/{taskId}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Integer taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            return ResponseEntity.ok(optionalTask.get().getMessages());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Integer taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            return ResponseEntity.ok(optionalTask.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
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
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @PostMapping("")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        task.setStatus(Task.Status.NEW);
        Task savedTask = taskRepository.save(task);
        return ResponseEntity.ok(savedTask);
    }

    @Secured({ "ROLE_ADMIN" })
    @DeleteMapping("/{taskId}")
    public ResponseEntity deleteTask(@PathVariable Integer taskId){
        try {
            taskRepository.deleteById(taskId);
            return ResponseEntity.ok().build();
        }catch(EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }
    @Secured({ "ROLE_ADMIN" })
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
