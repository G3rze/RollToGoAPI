package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.RecommendedPath;
import com.terraplanistas.api.service.RecommendedPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recommended-path")
public class RecommendedPathController {

    @Autowired
    private RecommendedPathService recommendedPathService;

    @GetMapping
    public List<RecommendedPath> getAllRecommendedPath() {
        return recommendedPathService.findAll();
    }

    @GetMapping("/{id}")
    public RecommendedPath getRecommendedPathById(@PathVariable UUID id) {
        return recommendedPathService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "RecommendedPath not found with id: " + id));
    }

    @PostMapping
    public RecommendedPath createRecommendedPath(@RequestBody RecommendedPath RecommendedPath) {
        return recommendedPathService.save(RecommendedPath);
    }

    @PutMapping("/{id}")
    public RecommendedPath updateRecommendedPath(@PathVariable UUID id, @RequestBody RecommendedPath RecommendedPath) {
        if (recommendedPathService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "RecommendedPath not found with id: " + id);
        }
        return recommendedPathService.save(RecommendedPath);
    }

    @DeleteMapping
    public void deleteRecommendedPath(@RequestBody UUID id) {
        recommendedPathService.deleteById(id);
    }
}
