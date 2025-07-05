package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.CreatureCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Creature;
import com.terraplanistas.api.service.ContentService;
import com.terraplanistas.api.service.CreatureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/creatures")
public class CreatureController {

    @Autowired
    private CreatureService creatureService;
    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Creature> findAll() {
        return creatureService.findAll();
    }

    @GetMapping("/{id}")
    public Creature findById(@PathVariable UUID id) {
        return creatureService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CreatureCreateDTO creatureCreateDTO) {
        Content content;
        try {
            content = contentService.findById(UUID.fromString(creatureCreateDTO.getContentId()));
            if (content == null) {return ResponseEntity.notFound().build();}
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error encontrando content " + e.getMessage());
        }

        Creature creature = new Creature();
        creature.setName(creatureCreateDTO.getName());
        creature.setAlignmentEnum(creatureCreateDTO.getAlignmentEnum());
        creature.setCreatureSourceType(creatureCreateDTO.getCreatureSourceType());
        creature.setBaseAc(creatureCreateDTO.getBaseAc());
        creature.setBaseHp(creatureCreateDTO.getBaseHp());
        creature.setSizeEnum(creatureCreateDTO.getSizeEnum());
        creature.setTypeEnum(creatureCreateDTO.getTypeEnum());
        creature.setContent(content);

        try {
            creatureService.save(creature);
            return ResponseEntity.ok().body(creature);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error guardando creature " + e.getMessage());
        }
    }

    @PutMapping
    public Creature update(@RequestBody Creature creature) {
        return creatureService.update(creature);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        creatureService.deleteById(id);
    }

}
