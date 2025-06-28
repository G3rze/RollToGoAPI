package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.SkillCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Skill;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SkillCreateDTO skillCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(skillCreateDTO.getContentId());
            content = contentService.findById(contentUuid);

            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + skillCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        Skill skill = new Skill();
        skill.setContent(content);
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
