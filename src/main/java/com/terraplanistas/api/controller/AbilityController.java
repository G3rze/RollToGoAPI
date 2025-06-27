package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.AbilityCreateDTO;
import com.terraplanistas.api.model.Ability;
import com.terraplanistas.api.service.AbilityService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/ability")
public class AbilityController {

    @Autowired
    AbilityService abilityService;

    @GetMapping
    public List<Ability> getAllAbility() {
        return abilityService.findAll();
    }

    @GetMapping("/{id}")
    public Ability getAbilityById(@PathVariable UUID id) {
        return abilityService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> createAbility(@Valid @RequestBody AbilityCreateDTO abilityDTO){
        if (abilityDTO.getContentId() == null) {
            return ResponseEntity.badRequest().body("contentId es requerido");
        }

        Ability ability = new Ability();
        ability.setAbilityTypeEnum(abilityDTO.getAbilityTypeEnum());
        ability.setModifier(abilityDTO.getModifier());
        ability.setValue(abilityDTO.getValue());

        try {
            Ability savedAbility = abilityService.save(ability);
            return ResponseEntity.ok(savedAbility);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al crear la ability: " + e.getMessage());
        }
    }

    @PutMapping
    public Ability updateAbility(@RequestBody Ability ability) {
        return abilityService.update(ability);
    }

    @DeleteMapping("/{id}")
    public void deleteAbility(@PathVariable UUID id) {
        abilityService.deleteById(id);
    }

}
