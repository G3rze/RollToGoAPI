package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Grant;
import com.terraplanistas.api.repository.GrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GrantService {

    @Autowired
    private GrantRepository grantRepository;

    public List<Grant> findAll(){
        return grantRepository.findAll();
    }

    public Grant findById(UUID id){
        return grantRepository.findById(id).orElse(null);
    }

    public Grant save(Grant grant){
        return grantRepository.save(grant);
    }

    public Grant update(Grant grant){
        return grantRepository.save(grant);
    }
    public void deleteById(UUID id){
        grantRepository.deleteById(id);
    }

}
