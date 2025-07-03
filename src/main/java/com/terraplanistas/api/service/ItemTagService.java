package com.terraplanistas.api.service;

import com.terraplanistas.api.model.ItemTag;
import com.terraplanistas.api.repository.ItemTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemTagService {

    @Autowired
    private ItemTagRepository itemTagRepository;

    public List<ItemTag> findAll(){
        return itemTagRepository.findAll();
    }

    public ItemTag findById(UUID id){
        return itemTagRepository.findById(id).orElse(null);
    }

    public ItemTag save(ItemTag itemTag){
        return itemTagRepository.save(itemTag);
    }

    public ItemTag update(ItemTag itemTag){
        return itemTagRepository.save(itemTag);

    }

    public void deleteById(UUID id){
        itemTagRepository.deleteById(id);
    }

}
