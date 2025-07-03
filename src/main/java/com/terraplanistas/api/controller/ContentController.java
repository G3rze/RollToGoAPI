package com.terraplanistas.api.controller;


import com.terraplanistas.api.controller.DTO.ContentCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.User;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/content")
public class ContentController {

    @Autowired
    private ContentService contentService;
    @Autowired
    private UserService userService;

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
    public ResponseEntity<?> save(@Valid @RequestBody ContentCreateDTO contentCreateDTO) {
        User author;
        try {
            author = userService.findById(contentCreateDTO.getAuthorId());

            if (author == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El autor con ID " + contentCreateDTO.getAuthorId() + " no fue encontrado");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID del autor proporcionado no es un formato UUID válido");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al buscar el autor: " + e.getMessage());
        }
        Content content = new Content();

        content.setSourceContentEnum(contentCreateDTO.getSourceContentEnum());
        content.setVisibilityEnum(contentCreateDTO.getVisibilityEnum());
        content.setCreatedAt(OffsetDateTime.now());
        content.setAuthor(author);

        try {
            Content savedContent = contentService.save(content);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedContent);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al crear el contenido: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        contentService.deleteById(id);
    }

}
