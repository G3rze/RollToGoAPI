package com.terraplanistas.api.service;

import com.terraplanistas.api.model.RoomParticipant;
import com.terraplanistas.api.repository.RoomParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomParticipantService {

    @Autowired
    private RoomParticipantRepository roomParticipantRepository;

    public List<RoomParticipant> findAll(){
        return roomParticipantRepository.findAll();
    }

    public RoomParticipant findById(UUID id){
        return roomParticipantRepository.findById(id).orElse(null);
    }

    public RoomParticipant save(RoomParticipant roomParticipant){
        return roomParticipantRepository.save(roomParticipant);
    }

    public RoomParticipant update(RoomParticipant roomParticipant){
        return roomParticipantRepository.save(roomParticipant);

    }

    public void deleteById(UUID id){
        roomParticipantRepository.deleteById(id);
    }

}
