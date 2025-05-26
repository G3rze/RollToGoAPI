package com.terraplanistas.api.service;

import com.terraplanistas.api.model.RoomChat;
import com.terraplanistas.api.repository.RoomChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomChatService {

    @Autowired
    private RoomChatRepository roomChatRepository;

    public List<RoomChat> findAll() {
        return roomChatRepository.findAll();
    }

    public Optional<RoomChat> findById(UUID id) {
        return roomChatRepository.findById(id);
    }

    public RoomChat save(RoomChat roomChat) {
        return roomChatRepository.save(roomChat);
    }

    public void deleteById(UUID id) {
        roomChatRepository.deleteById(id);
    }
}
