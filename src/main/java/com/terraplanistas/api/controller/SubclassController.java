package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.SubclassCreateDTO;
import com.terraplanistas.api.model.Class;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Subclass;
import com.terraplanistas.api.service.ClassService;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.RoomService;
import com.terraplanistas.api.service.SubclassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subclasses")
public class SubclassController {

    @Autowired
    private SubclassService subclassService;
    @Autowired
    private ClassService classService;
    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Subclass> findAll() {
        return subclassService.findAll();
    }

    @GetMapping("/{id}")
    public Subclass findById(@PathVariable UUID id) {
        return subclassService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SubclassCreateDTO subclassCreateDTO) {
        Content content;
        Class clazz;

        try {
            UUID contentUuid = UUID.fromString(subclassCreateDTO.getContentId());
            content = contentService.findById(contentUuid);
            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + subclassCreateDTO.getContentId() + " no existe.");
            }

            UUID classUuid = UUID.fromString(subclassCreateDTO.getClassId());
            clazz = classService.findById(classUuid);
            if (clazz == null) {
                return ResponseEntity.badRequest().body("La clase con ID " + subclassCreateDTO.getClassId() + " no existe.");
            }

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Uno de los IDs proporcionados no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar las entidades relacionadas (contenido o clase): " + e.getMessage());
        }

        Subclass subclass = new Subclass();
        subclass.setContent(content);
        subclass.setClazz(clazz);
        subclass.setClassId(clazz.getId());
        subclass.setName(subclassCreateDTO.getName());
        subclass.setDescription(subclassCreateDTO.getDescription());

        try {
            Subclass savedSubclass = subclassService.save(subclass);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSubclass);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la subclase: " + e.getMessage());
        }
    }

    @PutMapping
    public Subclass update(@RequestBody Subclass subclass) {
        return subclassService.update(subclass);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        subclassService.deleteById(id);
    }

}
