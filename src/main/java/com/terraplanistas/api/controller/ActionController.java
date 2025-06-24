package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Action;
import com.terraplanistas.api.repository.ActionRepository;
import com.terraplanistas.api.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/actions")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @GetMapping
    public List<Action> findAll() {
        return actionService.findAll();
    }

    @GetMapping("/{id}")
    public Action findById(@PathVariable UUID id) {
        return actionService.findById(id);
    }

    @PostMapping
    public Action save(@RequestBody Action action) {
        return actionService.save(action);
    }

    @PutMapping
    public Action update(@RequestBody Action action) {
        return actionService.save(action);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        actionService.deleteById(id);
    }

}
