package com.terraplanistas.api.model.compound_ids;

import java.io.Serializable;
import java.util.UUID;

public class GrantOptionItemId implements Serializable {
    private UUID granterOptionSetId;
    private UUID grantedContentId;

    public GrantOptionItemId() {}

    public GrantOptionItemId(UUID granterOptionSetId, UUID grantedContentId) {
        this.granterOptionSetId = granterOptionSetId;
        this.grantedContentId = grantedContentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrantOptionItemId that = (GrantOptionItemId) o;
        return granterOptionSetId.equals(that.granterOptionSetId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(granterOptionSetId, grantedContentId);
    }

}
