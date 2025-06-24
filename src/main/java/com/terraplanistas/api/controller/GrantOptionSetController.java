package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.GrantOptionSet;
import com.terraplanistas.api.service.GrantOptionSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/grant-option-sets")
public class GrantOptionSetController {

    @Autowired
    private GrantOptionSetService grantOptionSetService;

    @GetMapping
    public List<GrantOptionSet> findAll() {
        return grantOptionSetService.findAll();
    }

    @GetMapping("/{id}")
    public GrantOptionSet findById(@PathVariable UUID id) {
        return grantOptionSetService.findById(id);
    }

    @PostMapping
    public GrantOptionSet save(@RequestBody GrantOptionSet grantOptionSet) {
        return grantOptionSetService.save(grantOptionSet);
    }

    @PutMapping
    public GrantOptionSet update(@RequestBody GrantOptionSet grantOptionSet) {
        return grantOptionSetService.update(grantOptionSet);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        grantOptionSetService.deleteById(id);
    }
}
