package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Action;
import com.terraplanistas.api.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    public List<Action> findAll(){
        return actionRepository.findAll();
    }

    public Action findById(UUID id){
        return actionRepository.findById(id).orElse(null);
    }

    public Action save(Action action){
        return actionRepository.save(action);
    }

    public Action update(Action action){
        return actionRepository.save(action);
    }

    public void deleteById(UUID id){
        actionRepository.deleteById(id);
    }


}
