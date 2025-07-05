package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.CharacterCreateDTO;
import com.terraplanistas.api.model.Creature;
import com.terraplanistas.api.service.CharacterService;
import com.terraplanistas.api.model.Character;
import com.terraplanistas.api.service.CreatureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;
    @Autowired
    private CreatureService creatureService;

    @GetMapping
    public List<Character> findAll() {
        return characterService.findAll();
    }

    @GetMapping("/{id}")
    public Character findById(@PathVariable UUID id) {
        return characterService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CharacterCreateDTO characterCreateDTO) {
        Creature creature;
        try {
            creature = creatureService.findById(UUID.fromString(characterCreateDTO.getCreatureId()));
            if (creature == null) return ResponseEntity.badRequest().body("creature id no existe");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error encontrando criatura: " + e.getMessage());
        }
        Character character = new Character();
        character.setAge(characterCreateDTO.getAge());
        character.setName(characterCreateDTO.getName());
        character.setAlignment(characterCreateDTO.getAlignment());
        characterCreateDTO.setAppearance(characterCreateDTO.getAppearance());
        character.setBiography(characterCreateDTO.getBiography());
        character.setEyeColor(characterCreateDTO.getEyeColor());
        character.setHairColor(characterCreateDTO.getHairColor());
        character.setFaith(characterCreateDTO.getFaith());
        character.setIdeals(characterCreateDTO.getIdeals());
        character.setPersonality(characterCreateDTO.getPersonality());
        character.setFlaws(characterCreateDTO.getFlaws());
        character.setHeight(characterCreateDTO.getHeight());
        character.setWeight(characterCreateDTO.getWeight());
        character.setSkinColor(characterCreateDTO.getSkinColor());
        character.setGender(characterCreateDTO.getGender());
        character.setCreature(creature);

        try {
            Character savedCharacter = characterService.save(character);
            return ResponseEntity.ok(savedCharacter);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al crear el character: " + e.getMessage());
        }
    }

    @PutMapping
    public Character update(@RequestBody Character character) {
        return characterService.update(character);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        characterService.deleteById(id);
    }

}
