package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.SkillCreateDTO;
import com.terraplanistas.api.model.Ability;
import com.terraplanistas.api.model.Skill;
import com.terraplanistas.api.service.AbilityService;
import com.terraplanistas.api.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<Skill> findAll() {
        return skillService.findAll();
    }

    @GetMapping("/{id}")
    public Skill findById(@PathVariable UUID id) {
        return skillService.findById(id);
    }

    @Autowired
    private AbilityService abilityService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SkillCreateDTO skillCreateDTO) {
        Ability ability;
        try {
            UUID contentUuid = UUID.fromString(skillCreateDTO.getAbilityId());
            ability = abilityService.findById(contentUuid);

            if (ability == null) {
                return ResponseEntity.badRequest().body("La habilidad con ID " + skillCreateDTO.getAbilityId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        Skill skill = new Skill();
        skill.setAbility(ability);
        skill.setSkillTypeEnum(skillCreateDTO.getSkillTypeEnum());
        skill.setProficiencyLevelEnum(skillCreateDTO.getProficiencyLevelEnum());

        try {
            Skill savedSkill = skillService.save(skill);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSkill);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la habilidad: " + e.getMessage());
        }
    }

    @PutMapping
    public Skill update(@RequestBody Skill skill) {
        return skillService.update(skill);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        skillService.deleteById(id);
    }

}
