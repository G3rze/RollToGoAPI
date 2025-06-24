package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Bonus;
import com.terraplanistas.api.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bonus")
public class BonusController {

    @Autowired
    private BonusService bonusService;

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
    public Bonus save(@RequestBody Bonus bonus) {
        return bonusService.save(bonus);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        bonusService.deleteById(id);
    }


}
