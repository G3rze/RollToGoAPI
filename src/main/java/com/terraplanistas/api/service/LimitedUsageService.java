package com.terraplanistas.api.service;

import com.terraplanistas.api.model.LimitedUsage;
import com.terraplanistas.api.repository.LimitedUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LimitedUsageService {

    @Autowired
    private LimitedUsageRepository limitedUsageRepository;

    public List<LimitedUsage> findAll(){
        return limitedUsageRepository.findAll();
    }

    public LimitedUsage findById(UUID id){
        return limitedUsageRepository.findById(id).orElse(null);
    }

    public LimitedUsage save(LimitedUsage limitedUsage){
        return limitedUsageRepository.save(limitedUsage);
    }

    public LimitedUsage update(LimitedUsage limitedUsage){
        return limitedUsageRepository.save(limitedUsage);

    }

    public void deleteById(UUID id){
        limitedUsageRepository.deleteById(id);
    }

}
