package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.InvocationCreateDTO;
import com.terraplanistas.api.model.Creature;
import com.terraplanistas.api.model.Invocation;
import com.terraplanistas.api.service.CreatureService;
import com.terraplanistas.api.service.InvocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/invocations")
public class InvocationController {

    @Autowired
    private InvocationService invocationService;

    @GetMapping
    public List<Invocation> findAll() {
        return invocationService.findAll();
    }

    @GetMapping("/{id}")
    public Invocation findById(@PathVariable UUID id) {
        return invocationService.findById(id);
    }

    @Autowired
    private CreatureService creatureService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody InvocationCreateDTO invocationCreateDTO) {
        Creature creature;
        try {
            UUID creatureUuid = UUID.fromString(invocationCreateDTO.getCreatureId());
            creature = creatureService.findById(creatureUuid);

            if (creature == null) {
                return ResponseEntity.badRequest().body("La criatura con ID " + invocationCreateDTO.getCreatureId() + " no existe.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("El ID de criatura proporcionado no es un formato UUID válido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al encontrar la criatura: " + e.getMessage());
        }

        Invocation invocation = new Invocation();
        invocation.setCreature(creature);
        invocation.setDurationValue(invocationCreateDTO.getDurationValue());
        invocation.setDurationUnitEnum(invocationCreateDTO.getDurationUnitEnum());

        try {
            Invocation savedInvocation = invocationService.save(invocation);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedInvocation);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar la invocación: " + e.getMessage());
        }
    }


    @PutMapping
    public Invocation update(@RequestBody Invocation invocation) {
        return invocationService.update(invocation);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        invocationService.deleteById(id);
    }

}
