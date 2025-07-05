package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.ChatMessageCreateDTO;
import com.terraplanistas.api.controller.responseDTO.ChatMessageResponseDTO;
import com.terraplanistas.api.model.ChatMessage;
import com.terraplanistas.api.model.Room;
import com.terraplanistas.api.model.User;
import com.terraplanistas.api.service.ChatMessageService;
import com.terraplanistas.api.service.RoomService;
import com.terraplanistas.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.OffsetDateTime;
import java.util.UUID;

@Controller
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @MessageMapping("ws/{roomId}")
    public void sendMessage(@Payload ChatMessageCreateDTO dto) {
        Room room = roomService.findById(UUID.fromString(dto.getRoomId()));
        User sender = userService.findById(dto.getSender());

        ChatMessage entity = new ChatMessage();
        entity.setRoom(room);
        entity.setSender(sender);
        entity.setContent(dto.getContent());
        entity.setCreatedAt(OffsetDateTime.now());

        ChatMessage saved = chatMessageService.save(entity);

        ChatMessageResponseDTO response = new ChatMessageResponseDTO();
        response.setId(saved.getId().toString());
        response.setRoomId(saved.getRoom().getId().toString());
        response.setSenderId(saved.getSender().getId());
        response.setSender(sender.getUsername()); // Asumiendo que tienes este campo
        response.setContent(saved.getContent());
        response.setCreatedAt(saved.getCreatedAt());

        messagingTemplate.convertAndSend("/topic/room-chat/" + dto.getRoomId(), response);
    }

}
