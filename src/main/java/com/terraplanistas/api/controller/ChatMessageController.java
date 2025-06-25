package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.ChatMessage;
import com.terraplanistas.api.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(ChatMessage chatMessage) {
        ChatMessage saved = chatMessageService.save(chatMessage);
        // Envía el mensaje solo a los suscritos al room correspondiente
        messagingTemplate.convertAndSend("/room-chat/" + saved.getRoomId(), saved);
    }
}