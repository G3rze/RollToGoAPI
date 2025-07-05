package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.SpellMaterialCreateDTO;
import com.terraplanistas.api.model.Item;
import com.terraplanistas.api.model.Spell;
import com.terraplanistas.api.model.SpellMaterial;
import com.terraplanistas.api.service.ItemService;
import com.terraplanistas.api.service.SpellMaterialService;
import com.terraplanistas.api.service.SpellService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/spell-material")
public class SpellMaterialController {

    @Autowired
    private SpellMaterialService spellMaterialService;

    @GetMapping
    public List<SpellMaterial> findAll() {
        return spellMaterialService.findAll();
    }

    @GetMapping("/{id}")
    public SpellMaterial findById(@PathVariable UUID id) {
        return spellMaterialService.findById(id);
    }

    @Autowired
    private SpellService spellService;

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody SpellMaterialCreateDTO spellMaterialCreateDTO) {
        Spell spell;
        Item item;
        try {
            UUID spellUuid = UUID.fromString(spellMaterialCreateDTO.getSpellId());
            spell = spellService.findById(spellUuid);
            if (spell == null) {
                return ResponseEntity.badRequest().body("El hechizo con ID " + spellMaterialCreateDTO.getSpellId() + " no existe.");
            }
            UUID itemUuid = UUID.fromString(spellMaterialCreateDTO.getItemId());
            item = itemService.findById(itemUuid);
            if (item == null) {
                return ResponseEntity.badRequest().body("El ítem con ID " + spellMaterialCreateDTO.getItemId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Uno de los IDs proporcionados no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el hechizo o el ítem: " + e.getMessage());
        }

        SpellMaterial spellMaterial = new SpellMaterial();
        spellMaterial.setSpell(spell);
        spellMaterial.setItem(item);
        try {
            SpellMaterial savedSpellMaterial = spellMaterialService.save(spellMaterial);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSpellMaterial);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el material del hechizo: " + e.getMessage());
        }
    }
    @PutMapping
    public SpellMaterial update(@RequestBody SpellMaterial spellMaterial) {
        return spellMaterialService.update(spellMaterial);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        spellMaterialService.deleteById(id);
    }
}
