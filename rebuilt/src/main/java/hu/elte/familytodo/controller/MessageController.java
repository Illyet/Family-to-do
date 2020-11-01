package hu.elte.familytodo.controller;


import hu.elte.familytodo.model.Message;
import hu.elte.familytodo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private MessageRepository messageRepository;

    public MessageController(@Autowired MessageRepository messageRepository) {this.messageRepository = messageRepository;}

    @GetMapping("")
    public ResponseEntity<Iterable<Message>> getMessages(@RequestParam(required = false) String title) {
        Iterable<Message> messages;
        messages = messageRepository.findAll();
        return ResponseEntity.ok(messages);
    }

    @PostMapping("")
    public ResponseEntity<Message> post(@RequestBody Message description) {
        Message savedDescription = messageRepository.save(description);
        return ResponseEntity.ok(savedDescription);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Message> put(@RequestBody Message message, @PathVariable Integer id) {
        Optional<Message> oMessage = messageRepository.findById(id);
        if (oMessage.isPresent()) {
            message.setId(id);
            return ResponseEntity.ok(messageRepository.save(message));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Message> oDescription = messageRepository.findById(id);
        if (oDescription.isPresent()) {
            messageRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
