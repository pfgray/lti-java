package net.paulgray.lti.contentitem;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.inferred.freebuilder.FreeBuilder;

import java.time.Instant;
import java.util.Optional;

@FreeBuilder
@JsonDeserialize(builder = ContentItem.Builder.class)
public interface ContentItem extends Item {

    String TYPE = "ContentItem";

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();
    /** Builder of instances. */
    class Builder extends ContentItem_Builder {
        public Builder() {
            // Set defaults in the builder constructor.
            type(TYPE);
            url(Optional.empty());
            text(Optional.empty());
            title(Optional.empty());
            placementAdvice(Optional.empty());
            expiresAt(Optional.empty());
            icon(Optional.empty());
            thumbnail(Optional.empty());
        }
    }
}
