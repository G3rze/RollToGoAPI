package com.terraplanistas.api.service;

import com.terraplanistas.api.model.RoomEntity;
import com.terraplanistas.api.repository.RoomEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomEntityService {

    @Autowired
    private RoomEntityRepository roomEntityRepository;

    public Optional<RoomEntity> findById(UUID id) {
        return roomEntityRepository.findById(id);
    }

    public List<RoomEntity> findAll() {
        return roomEntityRepository.findAll();
    }

    public RoomEntity save(RoomEntity roomEntity) {
        return roomEntityRepository.save(roomEntity);
    }

    public void deleteById(UUID id) {
        roomEntityRepository.deleteById(id);
    }

}
