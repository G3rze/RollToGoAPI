package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.GrantOptionItemCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.GrantOptionItem;
import com.terraplanistas.api.model.GrantOptionSet;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.GrantOptionItemService;
import com.terraplanistas.api.service.GrantOptionSetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/grant-option-items")
public class GrantOptionItemController {

    @Autowired
    private GrantOptionItemService grantOptionItemService;

    @GetMapping
    public List<GrantOptionItem> findAll() {
        return grantOptionItemService.findAll();
    }

    @GetMapping("/{id}")
    public GrantOptionItem findById(@PathVariable UUID id) {
        return grantOptionItemService.findById(id);
    }

    @Autowired
    private GrantOptionSetService grantOptionSetService;

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody GrantOptionItemCreateDTO grantOptionItemCreateDTO) {
        GrantOptionSet granterOptionSet;
        Content grantedContent;

        try {
            UUID granterOptionSetUuid = UUID.fromString(grantOptionItemCreateDTO.getGranterOptionSetId());
            granterOptionSet = grantOptionSetService.findById(granterOptionSetUuid);
            if (granterOptionSet == null) {
                return ResponseEntity.badRequest().body("El conjunto de opciones otorgante con ID " + grantOptionItemCreateDTO.getGranterOptionSetId() + " no existe.");
            }
            UUID grantedContentUuid = UUID.fromString(grantOptionItemCreateDTO.getGrantedContentId());
            grantedContent = contentService.findById(grantedContentUuid);
            if (grantedContent == null) {
                return ResponseEntity.badRequest().body("El contenido otorgado con ID " + grantOptionItemCreateDTO.getGrantedContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Uno de los IDs proporcionados no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el conjunto de opciones otorgante o el contenido otorgado: " + e.getMessage());
        }

        GrantOptionItem grantOptionItem = new GrantOptionItem();
        grantOptionItem.setGranterOptionSet(granterOptionSet);
        grantOptionItem.setGrantedContent(grantedContent);
        try {
            GrantOptionItem savedGrantOptionItem = grantOptionItemService.save(grantOptionItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGrantOptionItem);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el ítem de opción de concesión: " + e.getMessage());
        }
    }

    @PutMapping
    public GrantOptionItem update(@RequestBody GrantOptionItem grantOptionItem) {
        return grantOptionItemService.update(grantOptionItem);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        grantOptionItemService.deleteById(id);
    }




}
