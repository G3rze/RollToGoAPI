package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.RoomChat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomChatRepository extends JpaRepository<RoomChat, UUID> {
}
