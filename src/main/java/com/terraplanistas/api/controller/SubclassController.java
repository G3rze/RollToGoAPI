package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Subclass;
import com.terraplanistas.api.service.SubclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subclasses")
public class SubclassController {

    @Autowired
    private SubclassService subclassService;

    @GetMapping
    public List<Subclass> findAll() {
        return subclassService.findAll();
    }

    @GetMapping("/{id}")
    public Subclass findById(@PathVariable UUID id) {
        return subclassService.findById(id);
    }

    @PostMapping
    public Subclass save(@RequestBody Subclass subclass) {
        return subclassService.save(subclass);
    }

    @PutMapping
    public Subclass update(@RequestBody Subclass subclass) {
        return subclassService.update(subclass);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        subclassService.deleteById(id);
    }

}
