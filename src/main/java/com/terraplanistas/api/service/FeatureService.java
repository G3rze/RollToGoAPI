package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Feature;
import com.terraplanistas.api.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public List<Feature> findAll() {
        return featureRepository.findAll();
    }

    public Feature findById(UUID id) {
        return featureRepository.findById(id).orElse(null);
    }

    public Feature save(Feature feature) {
        return featureRepository.save(feature);
    }

    public Feature update(Feature feature) {
        return featureRepository.save(feature);
    }

    public void deleteById(UUID id) {
        featureRepository.deleteById(id);
    }

}
