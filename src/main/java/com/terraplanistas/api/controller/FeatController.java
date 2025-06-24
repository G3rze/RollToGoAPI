package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Feat;
import com.terraplanistas.api.service.FeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/feats")
public class FeatController {

    @Autowired
    private FeatService featService;

    @GetMapping
    public List<Feat> findAll() {
        return featService.findAll();
    }

    @GetMapping("/{id}")
    public Feat findById(@PathVariable UUID id) {
        return featService.findById(id);
    }

    @PostMapping
    public Feat save(@RequestBody Feat feat) {
        return featService.save(feat);
    }

    @PutMapping
    public Feat update(@RequestBody Feat feat) {
        return featService.update(feat);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        featService.deleteById(id);
    }

}
