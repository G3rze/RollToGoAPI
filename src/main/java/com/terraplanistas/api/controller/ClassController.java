package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.ClassCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.service.ClassService;
import com.terraplanistas.api.model.Class;
import com.terraplanistas.api.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/classes")
public class ClassController {

    @Autowired
    private ClassService classService;
    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Class> findAll() {
        return classService.findAll();
    }

    @GetMapping("/{id}")
    public Class findById(@PathVariable UUID id) {
        return classService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ClassCreateDTO classCreateDTO) {
        Content content;
        try {
            content = contentService.findById(UUID.fromString(classCreateDTO.getContentId()));
            if (content == null) {return ResponseEntity.badRequest().body("Content no encontrado");}
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body("error encontrando content " + e.getMessage());
        }

        Class newClass = new Class();
        newClass.setName(classCreateDTO.getName());
        newClass.setDescription(classCreateDTO.getDescription());
        newClass.setHitDice(classCreateDTO.getHitDice());
        newClass.setHitPointsFirstLevel(classCreateDTO.getHitPointsFirstLevel());
        newClass.setHitPointsPerLevel(classCreateDTO.getHitPointsPerLevel());
        newClass.setContent(content);

        try {
            classService.save(newClass);
            return ResponseEntity.ok().body(newClass);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error guardando class " + e.getMessage());
        }
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
