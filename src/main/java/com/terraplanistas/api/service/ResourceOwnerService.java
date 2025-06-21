package com.terraplanistas.api.service;

import com.terraplanistas.api.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ResourceOwnerService {

    @Autowired
    private ContentRepository contentRepository;

    public boolean isOwner(UUID id, String uid) {
        return contentRepository.findById(id)
                .map(content -> uid.equals(content.getAuthor().getId()))
                .orElse(false);
    }
}
