package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.DTO.ChatMessageCreateDTO;
import com.terraplanistas.api.model.ChatMessage;
import com.terraplanistas.api.model.Room;
import com.terraplanistas.api.model.User;
import com.terraplanistas.api.service.ChatMessageService;
import com.terraplanistas.api.service.RoomService;
import com.terraplanistas.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    RoomService roomService;

    @Autowired
    UserService userService;

    @MessageMapping("/chat.sendM+essage")
    public void sendMessage(@RequestBody ChatMessageCreateDTO dto) {
        System.out.println("📨 Mensaje recibido: " + dto);

        ChatMessage entity = new ChatMessage();

        UUID roomUUID = UUID.fromString(dto.getRoomId());
        Room chatRoom = roomService.findById(roomUUID);

        User sender = userService.findById(dto.getSender());


        entity.setRoom(chatRoom);
        entity.setSender(sender);
        entity.setContent(dto.getContent());

        ChatMessage saved = chatMessageService.save(entity);
        messagingTemplate.convertAndSend("/room-chat/" + saved.getRoomId(), saved);
    }

}