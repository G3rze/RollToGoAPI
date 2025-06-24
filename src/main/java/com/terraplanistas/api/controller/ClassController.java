package com.terraplanistas.api.controller;

import com.terraplanistas.api.service.ClassService;
import com.terraplanistas.api.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public List<Class> findAll() {
        return classService.findAll();
    }

    @GetMapping("/{id}")
    public Class findById(@PathVariable UUID id) {
        return classService.findById(id);
    }

    @PostMapping
    public Class save(@RequestBody Class clazz) {
        return classService.save(clazz);
    }

    @PutMapping
    public Class update(@RequestBody Class clazz) {
        return classService.update(clazz);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        classService.deleteById(id);

    }
}
