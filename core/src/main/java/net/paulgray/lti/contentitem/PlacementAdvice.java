package net.paulgray.lti.contentitem;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.inferred.freebuilder.FreeBuilder;

import java.util.Optional;

@FreeBuilder
@JsonDeserialize(builder = PlacementAdvice.Builder.class)
public interface PlacementAdvice {

    Optional<String> presentationDocumentTarget();
    Optional<String> windowTarget();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();
    /** Builder of instances. */
    class Builder extends PlacementAdvice_Builder { }
}
