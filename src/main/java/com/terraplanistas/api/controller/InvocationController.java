package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Invocation;
import com.terraplanistas.api.service.InvocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invocations")
public class InvocationController {

    @Autowired
    private InvocationService invocationService;

    @GetMapping
    public List<Invocation> findAll() {
        return invocationService.findAll();
    }

    @GetMapping("/{id}")
    public Invocation findById(@PathVariable UUID id) {
        return invocationService.findById(id);
    }

    @PostMapping
    public Invocation save(@RequestBody Invocation invocation) {
        return invocationService.save(invocation);
    }

    @PutMapping
    public Invocation update(@RequestBody Invocation invocation) {
        return invocationService.update(invocation);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        invocationService.deleteById(id);
    }

}
