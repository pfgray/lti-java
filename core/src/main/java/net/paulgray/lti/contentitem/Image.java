package net.paulgray.lti.contentitem;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
@JsonDeserialize(builder = Image.Builder.class)
public interface Image {

    @JsonProperty("@id")
    String id();
    Integer width();
    Integer height();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();
    /** Builder of instances. */
    class Builder extends Image_Builder { }
}
