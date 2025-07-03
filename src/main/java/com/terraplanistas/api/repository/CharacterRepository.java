package com.terraplanistas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.terraplanistas.api.model.Character;


import java.util.UUID;

public interface CharacterRepository extends JpaRepository<Character, UUID> {
}
