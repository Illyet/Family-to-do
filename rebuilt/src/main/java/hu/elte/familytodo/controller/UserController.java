package hu.elte.familytodo.controller;


import hu.elte.familytodo.model.Task;
import hu.elte.familytodo.model.User;
import hu.elte.familytodo.repository.TaskRepository;
import hu.elte.familytodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private TaskRepository taskRepository;

    public UserController(@Autowired UserRepository userRepository, @Autowired TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<User>> getUsers(@RequestParam(required = false) String title) {
        Iterable<User> users;
        users = userRepository.findAll();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<Task>> getTasks(@PathVariable Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get().getCreatedTasks());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<User> post(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/{id}/tasks")
    public ResponseEntity<Task> postTask(@PathVariable Integer id, @RequestBody Task task) {
        Optional<User> oUser = userRepository.findById(id);
        if (oUser.isPresent()) {
            User user = oUser.get();
            Task newTask = taskRepository.save(task);
            user.getCreatedTasks().add(newTask);
            userRepository.save(user);
            return ResponseEntity.ok(newTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> put(@RequestBody User user, @PathVariable Integer id) {
        Optional<User> oUser = userRepository.findById(id);
        if (oUser.isPresent()) {
            user.setId(id);
            return ResponseEntity.ok(userRepository.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/tasks")
    public ResponseEntity<Iterable<Task>> modifyTasks(@PathVariable Integer id, @RequestBody List<Task> tasks) {
        Optional<User> oUser = userRepository.findById(id);
        if (oUser.isPresent()) {
            User user = oUser.get();


            for (Task task: tasks) {
                if (task.getId() == null) {
                    taskRepository.save(task);
                }
            }

            user.setCreatedTasks(tasks);
            userRepository.save(user);
            return ResponseEntity.ok(tasks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<User> oUser = userRepository.findById(id);
        if (oUser.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}