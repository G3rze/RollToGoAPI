package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.SenseCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Sense;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.SenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/senses")
public class SenseController {

    @Autowired
    private SenseService senseService;

    @GetMapping
    public List<Sense> findAll() {
        return senseService.findAll();
    }

    @GetMapping("/{id}")
    public Sense findById(@PathVariable UUID id) {
        return senseService.findById(id);
    }

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SenseCreateDTO senseCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(senseCreateDTO.getContentId());
            content = contentService.findById(contentUuid);

            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + senseCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        Sense sense = new Sense();
        sense.setContent(content);
        sense.setSensesTypeEnum(senseCreateDTO.getSensesTypeEnum());
        sense.setRangeValue(senseCreateDTO.getRangeValue());
        sense.setRangeUnitEnum(senseCreateDTO.getRangeUnitEnum());

        try {
            Sense savedSense = senseService.save(sense);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSense);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el sentido: " + e.getMessage());
        }
    }


    @PutMapping
    public Sense update(@RequestBody Sense sense) {
        return senseService.update(sense);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        senseService.deleteById(id);
    }

}
