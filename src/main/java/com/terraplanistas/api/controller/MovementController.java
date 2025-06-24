package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Movement;
import com.terraplanistas.api.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movements")
public class MovementController{

    @Autowired
    private MovementService movementService;

    @GetMapping
    public List<Movement> findAll() {
        return movementService.findAll();
    }

    @GetMapping("/{id}")
    public Movement findById(@PathVariable UUID id) {
        return movementService.findById(id);
    }

    @PostMapping
    public Movement save(@RequestBody Movement movement) {
        return movementService.save(movement);
    }

    @PutMapping
    public Movement update(@RequestBody Movement movement) {
        return movementService.update(movement);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        movementService.deleteById(id);
    }

}
