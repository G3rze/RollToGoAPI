package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Subspecies;
import com.terraplanistas.api.service.SubspeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subspecies")
public class SubspeciesController {

    @Autowired
    private SubspeciesService subspeciesService;

    @GetMapping
    public List<Subspecies> findAll() {
        return subspeciesService.findAll();
    }

    @GetMapping("/{id}")
    public Subspecies findById(@PathVariable UUID id) {
        return subspeciesService.findById(id);
    }

    @PostMapping
    public Subspecies save(@RequestBody Subspecies subspecies) {
        return subspeciesService.save(subspecies);
    }

    @PutMapping
    public Subspecies update(@RequestBody Subspecies subspecies) {
        return subspeciesService.update(subspecies);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        subspeciesService.deleteById(id);
    }

}
