package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.ItemTagCreateDTO;
import com.terraplanistas.api.model.Item;
import com.terraplanistas.api.model.ItemTag;
import com.terraplanistas.api.service.ItemService;
import com.terraplanistas.api.service.ItemTagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/item-tags")
public class ItemTagController {

    @Autowired
    private ItemTagService itemTagService;

    @GetMapping
    public List<ItemTag> findAll() {
        return itemTagService.findAll();
    }

    @GetMapping("/{id}")
    public ItemTag findById(@PathVariable UUID id) {
        return itemTagService.findById(id);
    }

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ItemTagCreateDTO itemTagCreateDTO) {
        Item item;
        try {
            UUID itemUuid = UUID.fromString(itemTagCreateDTO.getItemId());
            item = itemService.findById(itemUuid);

            if (item == null) {
                return ResponseEntity.badRequest().body("El ítem con ID " + itemTagCreateDTO.getItemId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID del ítem proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar el ítem: " + e.getMessage());
        }

        ItemTag itemTag = new ItemTag();
        itemTag.setItem(item);
        itemTag.setTag(itemTagCreateDTO.getTag());

        try {
            ItemTag savedItemTag = itemTagService.save(itemTag);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedItemTag);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la etiqueta del ítem: " + e.getMessage());
        }
    }

    @PutMapping
    public ItemTag update(@RequestBody ItemTag itemTag) {
        return itemTagService.update(itemTag);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        itemTagService.deleteById(id);
    }

}
