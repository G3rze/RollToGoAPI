package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.GrantOptionSetCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.GrantOptionSet;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.GrantOptionSetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/grant-option-sets")
public class GrantOptionSetController {

    @Autowired
    private GrantOptionSetService grantOptionSetService;
    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<GrantOptionSet> findAll() {
        return grantOptionSetService.findAll();
    }

    @GetMapping("/{id}")
    public GrantOptionSet findById(@PathVariable UUID id) {
        return grantOptionSetService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody GrantOptionSetCreateDTO grantOptionSetCreateDTO) {
        Content granterContent;
        try {
            UUID granterContentUuid = UUID.fromString(grantOptionSetCreateDTO.getGranterContentId());
            granterContent = contentService.findById(granterContentUuid);

            if (granterContent == null) {
                return ResponseEntity.badRequest().body("El contenido otorgante con ID " + grantOptionSetCreateDTO.getGranterContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido otorgante proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido otorgante: " + e.getMessage());
        }

        GrantOptionSet grantOptionSet = new GrantOptionSet();
        grantOptionSet.setContent(granterContent);
        grantOptionSet.setMinChoices(grantOptionSetCreateDTO.getMinChoices());
        grantOptionSet.setMaxChoices(grantOptionSetCreateDTO.getMaxChoices());

        try {
            GrantOptionSet savedGrantOptionSet = grantOptionSetService.save(grantOptionSet);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGrantOptionSet);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el conjunto de opciones de concesión: " + e.getMessage());
        }
    }

    @PutMapping
    public GrantOptionSet update(@RequestBody GrantOptionSet grantOptionSet) {
        return grantOptionSetService.update(grantOptionSet);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        grantOptionSetService.deleteById(id);
    }
}
