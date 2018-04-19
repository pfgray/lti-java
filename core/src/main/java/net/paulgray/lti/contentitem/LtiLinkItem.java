package net.paulgray.lti.contentitem;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.inferred.freebuilder.FreeBuilder;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@FreeBuilder
@JsonDeserialize(builder = LtiLinkItem.Builder.class)
public interface LtiLinkItem extends Item {

    String TYPE = "LtiLinkItem";
    String MEDIA_TYPE = "application/vnd.ims.lti.v1.ltilink";

    Map<String, String> custom();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();
    /** Builder of instances. */
    class Builder extends LtiLinkItem_Builder {
        Builder() {
            // Set defaults in the builder constructor.
            type(TYPE);
            mediaType(MEDIA_TYPE);
            putAllCustom(new HashMap<>());
        }
    }
}
