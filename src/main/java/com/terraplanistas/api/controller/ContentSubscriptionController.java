package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.ContentSubscription;
import com.terraplanistas.api.service.ContentSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Content-subscription")
public class ContentSubscriptionController {

    @Autowired
    private ContentSubscriptionService contentSubscriptionService;

    @GetMapping
    public List<ContentSubscription> getAllContentSubscription() {
        return contentSubscriptionService.findAll();
    }

    @GetMapping("/{id}")
    public ContentSubscription getContentSubscriptionById(@PathVariable UUID id) {
        return contentSubscriptionService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ContentSubscription not found with id: " + id));
    }

    @PostMapping
    public ContentSubscription createContentSubscription(@RequestBody ContentSubscription ContentSubscription) {
        return contentSubscriptionService.save(ContentSubscription);
    }

    @PutMapping("/{id}")
    public ContentSubscription updateContentSubscription(@PathVariable UUID id, @RequestBody ContentSubscription ContentSubscription) {
        if (contentSubscriptionService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ContentSubscription not found with id: " + id);
        }
        return contentSubscriptionService.save(ContentSubscription);
    }

    @DeleteMapping
    public void deleteContentSubscription(@RequestBody UUID id) {
        contentSubscriptionService.deleteById(id);
    }
}
