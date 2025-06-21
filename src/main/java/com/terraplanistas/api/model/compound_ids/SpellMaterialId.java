package com.terraplanistas.api.model.compound_ids;

import java.io.Serializable;
import java.util.UUID;

public class SpellMaterialId implements Serializable {
    private UUID itemId;
    private UUID spellId;

    public SpellMaterialId() {}

    public SpellMaterialId(UUID itemId, UUID spellId) {
        this.itemId = itemId;
        this.spellId = spellId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpellMaterialId that = (SpellMaterialId) o;
        return itemId.equals(that.itemId) && spellId.equals(that.spellId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(itemId, spellId);
    }
}
