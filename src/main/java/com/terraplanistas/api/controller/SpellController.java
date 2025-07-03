package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.SpeciesCreateDTO;
import com.terraplanistas.api.controller.DTO.SpellCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Species;
import com.terraplanistas.api.model.Spell;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.SpellService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/spells")
public class SpellController {

    @Autowired
    private SpellService spellService;

    @GetMapping
    public List<Spell> getAllSpells() {
        return spellService.findAll();
    }

    @GetMapping("/{id}")
    public Spell getSpellById(@PathVariable UUID id) {
        return spellService.findById(id);
    }

    @PutMapping
    public Spell updateSpell(@RequestBody Spell spell) {
        return spellService.update(spell);
    }

    @DeleteMapping("/{id}")
    public void deleteSpell(@PathVariable UUID id) {
        spellService.deleteById(id);
    }

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SpellCreateDTO spellCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(spellCreateDTO.getContentId());
            content = contentService.findById(contentUuid);
            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + spellCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        Spell spell = new Spell();
        spell.setContent(content);
        spell.setName(spellCreateDTO.getName());
        spell.setDescription(spellCreateDTO.getDescription());
        spell.setSpellComponents(spellCreateDTO.getSpellComponents());
        spell.setSpellLevelEnum(spellCreateDTO.getSpellLevelEnum());
        spell.setSpellSchoolEnum(spellCreateDTO.getSpellSchoolEnum());
        spell.setCastingTimeValue(spellCreateDTO.getCastingTimeValue());
        spell.setCastingTimeUnitEnum(spellCreateDTO.getCastingTimeUnitEnum());
        spell.setRangeValue(spellCreateDTO.getRangeValue());
        spell.setRangeUnitEnum(spellCreateDTO.getRangeUnitEnum());
        spell.setDurationValue(spellCreateDTO.getDurationValue());
        spell.setDurationUnitEnum(spellCreateDTO.getDurationUnitEnum());
        spell.setRitual(spellCreateDTO.getIsRitual());

        try {
            Spell savedSpell = spellService.save(spell);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSpell);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la especie: " + e.getMessage());
        }
    }

}
