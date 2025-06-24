package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Sense;
import com.terraplanistas.api.service.SenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/senses")
public class SenseController {

    @Autowired
    private SenseService senseService;

    @GetMapping
    public List<Sense> findAll() {
        return senseService.findAll();
    }

    @GetMapping("/{id}")
    public Sense findById(@PathVariable UUID id) {
        return senseService.findById(id);
    }

    @PostMapping
    public Sense save(@RequestBody Sense sense) {
        return senseService.save(sense);
    }

    @PutMapping
    public Sense update(@RequestBody Sense sense) {
        return senseService.update(sense);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        senseService.deleteById(id);
    }

}
