package com.terraplanistas.api.service;

import com.terraplanistas.api.model.RecommendedPath;
import com.terraplanistas.api.repository.RecommendedPathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecommendedPathService {

    @Autowired
    private RecommendedPathRepository recommendedPathRepository;

    public List<RecommendedPath> findAll() {
        return recommendedPathRepository.findAll();
    }

    public Optional<RecommendedPath> findById(UUID id) {
        return recommendedPathRepository.findById(id);
    }

    public RecommendedPath save(RecommendedPath recommendedPath) {
        return recommendedPathRepository.save(recommendedPath);
    }

    public void deleteById(UUID id) {
        recommendedPathRepository.deleteById(id);
    }
}
