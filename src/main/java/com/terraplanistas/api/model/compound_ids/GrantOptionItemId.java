package com.terraplanistas.api.model.compound_ids;

import java.io.Serializable;
import java.util.UUID;

public class GrantOptionItemId implements Serializable {
    private UUID granterOptionSet;
    private UUID grantedContent;

    public GrantOptionItemId() {}

    public GrantOptionItemId(UUID granterOptionSet, UUID grantedContent) {
        this.granterOptionSet = granterOptionSet;
        this.grantedContent = grantedContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrantOptionItemId that = (GrantOptionItemId) o;
        return granterOptionSet.equals(that.granterOptionSet);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(granterOptionSet, grantedContent);
    }

}
