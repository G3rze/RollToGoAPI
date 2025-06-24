package com.terraplanistas.api.controller;


import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Content> findAll(){
        return contentService.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable UUID id) {
        return contentService.findById(id);
    }

    @PutMapping
    public Content update(@RequestBody Content content) {
        return contentService.update(content);
    }

    @PostMapping
    public Content save(@RequestBody Content content) {
        return contentService.save(content);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        contentService.deleteById(id);
    }


}
