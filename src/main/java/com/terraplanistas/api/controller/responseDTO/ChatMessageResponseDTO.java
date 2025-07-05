package com.terraplanistas.api.controller.responseDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class ChatMessageResponseDTO {
    private String id;
    private String roomId;
    private String senderId;
    private String sender;
    private String content;
    private OffsetDateTime createdAt;
}