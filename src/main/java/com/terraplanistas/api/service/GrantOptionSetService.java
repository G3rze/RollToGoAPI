package com.terraplanistas.api.service;

import com.terraplanistas.api.model.GrantOptionSet;
import com.terraplanistas.api.repository.GrantOptionSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GrantOptionSetService {

    @Autowired
    public GrantOptionSetRepository grantOptionSetRepository;

    public List<GrantOptionSet> findAll() {
        return grantOptionSetRepository.findAll();
    }

    public GrantOptionSet findById(UUID id){
        return grantOptionSetRepository.findById(id).orElse(null);
    }

    public GrantOptionSet save(GrantOptionSet grantOptionSet){
        return grantOptionSetRepository.save(grantOptionSet);

    }

    public GrantOptionSet update(GrantOptionSet grantOptionSet) {
        return grantOptionSetRepository.save(grantOptionSet);

    }

    public void deleteById(UUID id){
        grantOptionSetRepository.deleteById(id);
    }


}

