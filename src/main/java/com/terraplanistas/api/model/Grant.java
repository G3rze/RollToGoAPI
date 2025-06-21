package com.terraplanistas.api.model;

import com.terraplanistas.api.model.enums.SourceContentEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "grants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grant {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "granter_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SourceContentEnum granterType;

    @ManyToOne
    @JoinColumn(name = "granter_content_id", nullable = false)
    private Content granterContent;

    @Column(name = "granted_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SourceContentEnum grantedType;

    @ManyToOne
    @JoinColumn(name = "granted_content_id", nullable = false)
    private Content grantedContent;
}
