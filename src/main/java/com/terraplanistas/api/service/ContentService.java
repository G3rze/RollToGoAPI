package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    public Content findById(UUID id) {
        return contentRepository.findById(id).orElse(null);
    }

    public Content save(Content content) {
        return contentRepository.save(content);
    }

    public Content update(Content content) {
        return contentRepository.save(content);
    }

    public void deleteById(UUID id) {
        contentRepository.deleteById(id);
    }

}
