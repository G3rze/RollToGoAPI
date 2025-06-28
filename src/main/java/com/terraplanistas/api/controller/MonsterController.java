package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.MonsterCreateDTO;
import com.terraplanistas.api.model.Creature;
import com.terraplanistas.api.model.Monster;
import com.terraplanistas.api.service.CreatureService;
import com.terraplanistas.api.service.MonsterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/monsters")
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping
    public List<Monster> findAll() {
        return monsterService.findAll();
    }

    @GetMapping("/{id}")
    public Monster findById(@PathVariable UUID id) {
        return monsterService.findById(id);
    }

    @Autowired
    private CreatureService creatureService; // Necesitas inyectar CreatureService para buscar la Creature

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody MonsterCreateDTO monsterCreateDTO) {
        Creature creature;
        try {
            UUID creatureUuid = UUID.fromString(monsterCreateDTO.getCreatureId());
            creature = creatureService.findById(creatureUuid);
            if (creature == null) {
                return ResponseEntity.badRequest().body("La criatura con ID " + monsterCreateDTO.getCreatureId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de criatura proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar la criatura: " + e.getMessage());
        }

        Monster monster = new Monster();
        monster.setCreature(creature);
        monster.setChallengeRating(monsterCreateDTO.getChallengeRating());
        monster.setLegendary(monsterCreateDTO.getLegendary());
        monster.setLair(monsterCreateDTO.getLair());

        try {
            Monster savedMonster = monsterService.save(monster);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMonster);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el monstruo: " + e.getMessage());
        }
    }

    @PutMapping
    public Monster update(@RequestBody Monster monster) {
        return monsterService.update(monster);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        monsterService.deleteById(id);
    }

}
