package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    
    @Autowired
    private ContentService contentService;
    
    @GetMapping
    public List<Content> getAllContent() {
        return contentService.findAll();
    }
    
    @GetMapping("/{id}")
    public Content getContentById(@PathVariable UUID id) {
        return contentService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found with id: " + id));
    }

    @PostMapping
    public Content createContent(@RequestBody Content content) {
        return contentService.save(content);
    }

    @PutMapping("/{id}")
    public Content updateContent(@PathVariable UUID id, @RequestBody Content content) {
        if (contentService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found with id: " + id);
        }
        return contentService.save(content);
    }

    @DeleteMapping
    public void deleteContent(@RequestBody UUID id) {
        contentService.deleteById(id);
    }
}
