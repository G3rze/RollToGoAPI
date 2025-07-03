package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Item;
import com.terraplanistas.api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(UUID id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item update(Item item) {
        return itemRepository.save(item);
    }

    public void deleteById(UUID id) {
        itemRepository.deleteById(id);
    }

}
