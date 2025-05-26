package com.terraplanistas.api.service;

import com.terraplanistas.api.model.ContentSubscription;
import com.terraplanistas.api.repository.ContentSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContentSubscriptionService {

    @Autowired
    private ContentSubscriptionRepository contentSubscriptionRepository;

    public List<ContentSubscription> findAll() {
        return contentSubscriptionRepository.findAll();
    }

    public Optional<ContentSubscription> findById(UUID id) {
        return contentSubscriptionRepository.findById(id);
    }

    public ContentSubscription save(ContentSubscription contentSubscription) {
        return contentSubscriptionRepository.save(contentSubscription);
    }

    public void deleteById(UUID id) {
        contentSubscriptionRepository.deleteById(id);
    }
}
