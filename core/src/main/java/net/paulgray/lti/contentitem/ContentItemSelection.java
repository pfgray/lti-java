package net.paulgray.lti.contentitem;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.inferred.freebuilder.FreeBuilder;

import java.util.List;

@FreeBuilder
@JsonDeserialize(builder = ContentItemSelection.Builder.class)
public interface ContentItemSelection {

    static String CONTEXT = "http://purl.imsglobal.org/ctx/lti/v1/Item";

    @JsonProperty("@context")
    String context();
    @JsonProperty("@graph")
    List<Item> graph();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();
    /** Builder of instances. */
    class Builder extends ContentItemSelection_Builder {
        public Builder() {
            // Set defaults in the builder constructor.
            context(CONTEXT);
        }
    }
}
