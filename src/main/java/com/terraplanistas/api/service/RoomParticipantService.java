package com.terraplanistas.api.service;

import com.terraplanistas.api.model.RoomParticipant;
import com.terraplanistas.api.repository.RoomParticipantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomParticipantService {

    @Autowired
    private RoomParticipantsRepository roomParticipantsRepository;

    public List<RoomParticipant> findAll() {
        return roomParticipantsRepository.findAll();
    }

    public Optional<RoomParticipant> findById(UUID id) {
        return roomParticipantsRepository.findById(id);
    }

    public RoomParticipant save(RoomParticipant roomParticipant) {
        return roomParticipantsRepository.save(roomParticipant);
    }

    public void deleteById(UUID id) {
        roomParticipantsRepository.deleteById(id);
    }

}
