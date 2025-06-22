package com.terraplanistas.api.repository;

import com.terraplanistas.api.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
