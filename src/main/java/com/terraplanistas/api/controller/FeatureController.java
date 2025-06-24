package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Feature;
import com.terraplanistas.api.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping
    public List<Feature> findAll() {
        return featureService.findAll();
    }

    @GetMapping("/{id}")
    public Feature findById(@PathVariable UUID id) {
        return featureService.findById(id);
    }

    @PostMapping
    public Feature save(@RequestBody Feature feature) {
        return featureService.save(feature);
    }

    @PutMapping
    public Feature update(@RequestBody Feature feature) {
        return featureService.update(feature);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        featureService.deleteById(id);
    }

}
