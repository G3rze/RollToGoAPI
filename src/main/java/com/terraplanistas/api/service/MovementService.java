package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Movement;
import com.terraplanistas.api.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    public List<Movement> findAll(){
        return movementRepository.findAll();
    }

    public Movement findById(UUID id){
        return movementRepository.findById(id).orElse(null);
    }

    public Movement save(Movement movement){
        return movementRepository.save(movement);
    }

    public Movement update(Movement movement){
        return movementRepository.save(movement);

    }

    public void deleteById(UUID id){
        movementRepository.deleteById(id);
    }

}
