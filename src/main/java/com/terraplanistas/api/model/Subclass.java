package com.terraplanistas.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "subclasses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subclass {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "class_id", nullable = false)
    private UUID classId;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class clazz;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}
