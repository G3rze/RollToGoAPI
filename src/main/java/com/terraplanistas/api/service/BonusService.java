package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Bonus;
import com.terraplanistas.api.repository.BonusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BonusService {

    @Autowired
    private BonusRepository bonusRepository;

    public List<Bonus> findAll() {
        return bonusRepository.findAll();
    }

    public Bonus findById(UUID id) {
        return bonusRepository.findById(id).orElse(null);
    }

    public Bonus save(Bonus bonus) {
        return bonusRepository.save(bonus);
    }

    public Bonus update(Bonus bonus) {
        return bonusRepository.save(bonus);
    }

    public void deleteById(UUID id) {
        bonusRepository.deleteById(id);
    }

}
