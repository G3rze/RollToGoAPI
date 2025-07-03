package com.terraplanistas.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.terraplanistas.api.model.enums.SourceContentEnum;
import com.terraplanistas.api.model.enums.VisibilityEnum;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "content")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "source_content_enum", nullable = false)
    private SourceContentEnum sourceContentEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "visibility_enum", nullable = false)
    private VisibilityEnum visibilityEnum = VisibilityEnum.PUBLIC;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "grantedContent")
    private List<Grant> grants;

    @OneToMany(mappedBy = "granterContent")
    private List<Grant> grantedBy;

    @OneToMany(mappedBy = "content")
    private List<GrantOptionSet> grantOptionSets;

    @OneToMany(mappedBy = "grantedContent")
    @JsonIgnore
    private List<GrantOptionItem> grantOptionItems;

}