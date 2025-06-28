package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.BackgroundCreateDTO;
import com.terraplanistas.api.model.Background;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.service.BackgroundService;
import com.terraplanistas.api.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/backgrounds")
public class BackgroundController {

    @Autowired
    private BackgroundService backgroundService;
    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Background> findAll() {
        return backgroundService.findAll();
    }

    @GetMapping("/{id}")
    public Background findById(@PathVariable UUID id) {
        return backgroundService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody BackgroundCreateDTO backgroundCreateDTO) {
        Content content;
        try {
            content = contentService.findById(UUID.fromString(backgroundCreateDTO.getContentId()));
            if (content == null) return ResponseEntity.badRequest().body("content id no existe");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error encontrando content: " + e.getMessage());
        }
        Background background = new Background();
        background.setName(backgroundCreateDTO.getName());
        background.setDescription(backgroundCreateDTO.getDescription());
        background.setContent(content);

        try {
            background = backgroundService.save(background);
            return ResponseEntity.ok().body(background);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error guardando background: " + e.getMessage());
        }
    }

    @PutMapping
    public Background update(@RequestBody Background background) {
        return backgroundService.update(background);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        backgroundService.deleteById(id);
    }




}
