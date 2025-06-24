package com.terraplanistas.api.service;

import com.terraplanistas.api.model.GrantOptionItem;
import com.terraplanistas.api.repository.GrantOptionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GrantOptionItemService {

    @Autowired
    private GrantOptionItemRepository grantOptionItemRepository;

    public List<GrantOptionItem> findAll(){
        return grantOptionItemRepository.findAll();
    }

    public GrantOptionItem findById(UUID id){
        return grantOptionItemRepository.findById(id).orElse(null);
    }

    public GrantOptionItem save(GrantOptionItem grantOptionItem) {
        return grantOptionItemRepository.save(grantOptionItem);
    }

    public GrantOptionItem update(GrantOptionItem grantOptionItem) {
        return grantOptionItemRepository.save(grantOptionItem);
    }

    public void deleteById(UUID id){
        grantOptionItemRepository.deleteById(id);
    }

}
