package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.BonusCreateDTO;
import com.terraplanistas.api.model.Bonus;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.service.BonusService;
import com.terraplanistas.api.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/bonus")
public class BonusController {

    @Autowired
    private BonusService bonusService;
    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Bonus> findAll() {
        return bonusService.findAll();
    }

    @GetMapping("/{id}")
    public Bonus findById(@PathVariable UUID id) {
        return bonusService.findById(id);
    }

    @PutMapping
    public Bonus update(@RequestBody Bonus bonus) {
        return bonusService.update(bonus);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody BonusCreateDTO bonusCreateDTO) {
        Content content;
        try {
            content = contentService.findById(UUID.fromString(bonusCreateDTO.getContentId()));
            if (content == null) {return ResponseEntity.badRequest().body("content no encontrado");}
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Error encontrando bonus " + e.getMessage());
        }

        Bonus bonus = new Bonus();
        bonus.setBonusTypeEnum(bonusCreateDTO.getBonusTypeEnum());
        bonus.setDiceFormula(bonusCreateDTO.getDiceFormula());
        bonus.setAbilityTypeEnum(bonusCreateDTO.getAbilityTypeEnum());
        bonus.setSkillTypeEnum(bonusCreateDTO.getSkillTypeEnum());
        bonus.setContent(content);

        try {
            bonusService.save(bonus);
            return ResponseEntity.ok().body(bonus);
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error guardando bonus " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        bonusService.deleteById(id);
    }


}
