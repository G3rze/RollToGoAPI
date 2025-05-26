package com.terraplanistas.api.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "firebase_uid", unique = true, nullable = false)
    private String firebaseUid;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}