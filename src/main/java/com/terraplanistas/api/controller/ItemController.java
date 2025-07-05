package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.ItemCreateDTO;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Item;
import com.terraplanistas.api.repository.ItemRepository;
import com.terraplanistas.api.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable UUID id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ItemCreateDTO itemCreateDTO) {
        Content content;
        try {
            UUID contentUuid = UUID.fromString(itemCreateDTO.getContentId());
            content = contentService.findById(contentUuid);

            if (content == null) {
                return ResponseEntity.badRequest().body("El contenido con ID " + itemCreateDTO.getContentId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de contenido proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el contenido: " + e.getMessage());
        }

        Item item = new Item();
        item.setContent(content);
        item.setName(itemCreateDTO.getName());
        item.setDescription(itemCreateDTO.getDescription());
        item.setItemTypeEnum(itemCreateDTO.getItemTypeEnum());
        item.setRarityEnum(itemCreateDTO.getRarityEnum());
        item.setWeight(itemCreateDTO.getWeight());
        item.setCostValue(itemCreateDTO.getCostValue());
        item.setCostCurrency(itemCreateDTO.getCostCurrency());
        item.setAttunementRequired(itemCreateDTO.getAttunementRequired());
        item.setIsMagic(itemCreateDTO.getIsMagic());

        try {
            Item savedItem = itemRepository.save(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el ítem: " + e.getMessage());
        }
    }

    @PutMapping
    public Item update(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        itemRepository.deleteById(id);
    }


}
