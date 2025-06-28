package com.terraplanistas.api.service;

import com.terraplanistas.api.model.ChatMessage;
import com.terraplanistas.api.repository.CharacterRepository;
import com.terraplanistas.api.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<ChatMessage> findAll() {
        return chatMessageRepository.findAll();
    }

    public ChatMessage findById(UUID id) {
        return chatMessageRepository.findById(id).orElse(null);
    }

    public ChatMessage save(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    public ChatMessage update(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    public void deleteById(UUID id) {
        chatMessageRepository.deleteById(id);
    }

    public List<ChatMessage> findByRoomId(UUID roomId) {

        return chatMessageRepository.findAll().stream()
                .filter(chatMessage -> chatMessage.getRoom().getId().equals(roomId))
                .collect(Collectors.toList());

    }

}
