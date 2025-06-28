package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.GrantCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Grant;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.GrantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/grants")
public class GrantController {

    @Autowired
    private GrantService grantService;

    @GetMapping
    public List<Grant> findAll() {
        return grantService.findAll();
    }

    @GetMapping("/{id}")
    public Grant findById(@PathVariable UUID id) {
        return grantService.findById(id);
    }

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody GrantCreateDTO grantCreateDTO) {
         Content granterContent;
        Content grantedContent;

        try {
            UUID granterContentUuid = UUID.fromString(grantCreateDTO.getGranterContentId());
            granterContent = contentService.findById(granterContentUuid);
            if (granterContent == null) {
                return ResponseEntity.badRequest().body("El contenido otorgante con ID " + grantCreateDTO.getGranterContentId() + " no existe.");
            }
            UUID grantedContentUuid = UUID.fromString(grantCreateDTO.getGrantedContentId());
            grantedContent = contentService.findById(grantedContentUuid);
            if (grantedContent == null) {
                return ResponseEntity.badRequest().body("El contenido concedido con ID " + grantCreateDTO.getGrantedContentId() + " no existe.");
            }

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Uno de los IDs de contenido proporcionados no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido otorgante o concedido: " + e.getMessage());
        }

        Grant grant = new Grant();
        grant.setGranterType(grantCreateDTO.getGranterType());
        grant.setGranterContent(granterContent);

        grant.setGrantedType(grantCreateDTO.getGrantedType());
        grant.setGrantedContent(grantedContent);

        try {
            Grant savedGrant = grantService.save(grant);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGrant);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la concesión: " + e.getMessage());
        }
    }



    @PutMapping
    public Grant update(@RequestBody Grant grant) {
        return grantService.update(grant);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        grantService.deleteById(id);
    }

}
