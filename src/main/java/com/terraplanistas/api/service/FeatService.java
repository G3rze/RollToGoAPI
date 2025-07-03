package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Feat;
import com.terraplanistas.api.repository.FeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FeatService {

    @Autowired
    private FeatRepository featRepository;

    public List<Feat> findAll() {
        return featRepository.findAll();
    }

    public Feat findById(UUID id) {
        return featRepository.findById(id).orElse(null);
    }

    public Feat save(Feat feat) {
        return featRepository.save(feat);
    }

    public Feat update(Feat feat) {
        return featRepository.save(feat);
    }

    public void deleteById(UUID id) {
        featRepository.deleteById(id);
    }

}
