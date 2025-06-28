package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.ActionCreateDTO;
import com.terraplanistas.api.model.Action;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.repository.ActionRepository;
import com.terraplanistas.api.service.ActionService;
import com.terraplanistas.api.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/actions")
public class ActionController {

    @Autowired
    private ActionService actionService;
    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Action> findAll() {
        return actionService.findAll();
    }

    @GetMapping("/{id}")
    public Action findById(@PathVariable UUID id) {
        return actionService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ActionCreateDTO actionCreateDTO) {
        Content content;
        try {
            content =  contentService.findById(UUID.fromString(actionCreateDTO.getContentId()));
            if (content == null) return ResponseEntity.badRequest().body("content id no existe");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error encontrando action: " + e.getMessage());
        }

        Action action = new Action();
        action.setActionType(actionCreateDTO.getActionType());
        action.setSaveDcFormula(actionCreateDTO.getSaveDcFormula());
        action.setIsRolled(actionCreateDTO.getIsRolled());
        action.setAttackFormula(actionCreateDTO.getAttackFormula());
        action.setSaveAbilityType(actionCreateDTO.getSaveAbilityType());
        action.setContent(content);

        try {
            action = actionService.save(action);
            return ResponseEntity.ok(action);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("error guardando action: " + e.getMessage());
        }
    }

    @PutMapping
    public Action update(@RequestBody Action action) {
        return actionService.save(action);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        actionService.deleteById(id);
    }

}
