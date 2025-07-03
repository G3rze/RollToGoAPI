package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Invocation;
import com.terraplanistas.api.repository.InvocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvocationService {

    @Autowired
    private InvocationRepository invocationRepository;

    public List<Invocation> findAll() {
        return invocationRepository.findAll();
    }
    public Invocation findById(UUID id) {
        return invocationRepository.findById(id).orElse(null);
    }
    public Invocation save(Invocation invocation) {
        return invocationRepository.save(invocation);
    }

    public Invocation update(Invocation invocation) {
        return invocationRepository.save(invocation);
    }

    public void deleteById(UUID id) {
        invocationRepository.deleteById(id);
    }


}
