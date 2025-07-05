package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.MovementCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Movement;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.MovementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/movements")
public class MovementController{

    @Autowired
    private MovementService movementService;

    @GetMapping
    public List<Movement> findAll() {
        return movementService.findAll();
    }

    @GetMapping("/{id}")
    public Movement findById(@PathVariable UUID id) {
        return movementService.findById(id);
    }

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody MovementCreateDTO movementCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(movementCreateDTO.getContentId());
            content = contentService.findById(contentUuid);
            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + movementCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        Movement movement = new Movement();
        movement.setContent(content);
        movement.setMaxMovementValue(movementCreateDTO.getMaxMovementValue());
        movement.setMaxMovementUnit(movementCreateDTO.getMaxMovementUnit());
        movement.setMovementTypeEnum(movementCreateDTO.getMovementTypeEnum());
        try {
            Movement savedMovement = movementService.save(movement);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovement);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el movimiento: " + e.getMessage());
        }
    }

    @PutMapping
    public Movement update(@RequestBody Movement movement) {
        return movementService.update(movement);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        movementService.deleteById(id);
    }

}
