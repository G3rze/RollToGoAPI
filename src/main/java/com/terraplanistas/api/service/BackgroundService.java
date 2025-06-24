package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Background;
import com.terraplanistas.api.repository.BackgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BackgroundService {

    @Autowired
    private BackgroundRepository backgroundRepository;

    public List<Background> findAll(){
        return backgroundRepository.findAll();
    }

    public Background findById(UUID id){
        return backgroundRepository.findById(id).orElse(null);
    }

    public Background save(Background background){
        return backgroundRepository.save(background);
    }

    public Background update(Background background){
        return backgroundRepository.save(background);
    }

    public void deleteById(UUID id){
        backgroundRepository.deleteById(id);
    }

}
