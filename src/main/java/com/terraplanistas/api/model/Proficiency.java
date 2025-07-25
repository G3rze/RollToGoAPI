package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.ProficiencyTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "proficiencies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proficiency {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Content content;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "proficiency_type_enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProficiencyTypeEnum proficiencyTypeEnum;
}
