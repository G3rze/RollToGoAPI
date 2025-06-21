package com.terraplanistas.api.model;

import com.terraplanistas.api.model.compound_ids.GrantOptionItemId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "grant_option_items")
@IdClass(GrantOptionItemId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrantOptionItem {
    @Id
    @ManyToOne
    @JoinColumn(name = "granter_option_set_id", referencedColumnName = "id")
    private GrantOptionSet granterOptionSet;

    @Id
    @ManyToOne
    @JoinColumn(name = "granted_content_id", referencedColumnName = "id")
    private Content grantedContent;
}
