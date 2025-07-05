package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.AbilityScoreImprovementCreateDTO;
import com.terraplanistas.api.model.AbilityScoreImprovement;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.service.AbilityScoreImprovementService;
import com.terraplanistas.api.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/ability_score_improvement")
public class AbilityScoreImprovementController{

    @Autowired
    private AbilityScoreImprovementService abilityScoreImprovementService;
    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<AbilityScoreImprovement> findAll(){
        return abilityScoreImprovementService.findAll();
    }

    @GetMapping("/{id}")
    public AbilityScoreImprovement findById(@PathVariable UUID id) {
        return abilityScoreImprovementService.findById(id);
    }

    @PutMapping
    public AbilityScoreImprovement update(@RequestBody AbilityScoreImprovement abilityScoreImprovement) {
        return abilityScoreImprovementService.update(abilityScoreImprovement);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody AbilityScoreImprovementCreateDTO abilityScoreImprovementCreateDTO) {
        Content content;
        try {
            content = contentService.findById(UUID.fromString(abilityScoreImprovementCreateDTO.getContentId()));
        }catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al crear el character: " + e.getMessage());
        }

        if (content == null) {
            return ResponseEntity.badRequest().body("content es requerido o no tiene un id válido");
        }

        AbilityScoreImprovement abilityScoreImprovement = new  AbilityScoreImprovement();

        abilityScoreImprovement.setAbilityTypeEnum(abilityScoreImprovementCreateDTO.getAbilityTypeEnum());
        abilityScoreImprovement.setContent(content);
        abilityScoreImprovement.setMaxPoints(abilityScoreImprovementCreateDTO.getMaxPoints());

        try {
            return ResponseEntity.ok(abilityScoreImprovementService.save(abilityScoreImprovement));
        } catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body("Error al guardar el character: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        abilityScoreImprovementService.deleteById(id);
    }

}
