package com.dqe.MongoPipeline;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Message saveMessage(@RequestBody Message message) {
        return repository.save(message);
    }

    // Get all messages
    @GetMapping
    public List<Message> getAll() {
        return repository.findAll();
    }

    // Get message by ID
    @GetMapping("/{id}")
    public Optional<Message> getById(@PathVariable String id) {
        return repository.findById(id);
    }
}
