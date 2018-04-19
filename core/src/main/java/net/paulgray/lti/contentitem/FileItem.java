package net.paulgray.lti.contentitem;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.inferred.freebuilder.FreeBuilder;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@FreeBuilder
@JsonDeserialize(builder = FileItem.Builder.class)
public interface FileItem extends Item {

    String TYPE = "FileItem";

    String copyAdvice();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();
    /** Builder of instances. */
    class Builder extends FileItem_Builder {
        Builder() {
            // Set defaults in the builder constructor.
            type(TYPE);
            copyAdvice("false");
        }
    }
}
