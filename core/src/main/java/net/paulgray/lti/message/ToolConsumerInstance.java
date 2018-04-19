package net.paulgray.lti.message;

import static net.paulgray.lti.LtiConstants.*;
import org.inferred.freebuilder.FreeBuilder;

import java.util.Optional;

@FreeBuilder
public interface ToolConsumerInstance {

    Optional<String> contactEmail();
    Optional<String> description();
    Optional<String> guid();
    Optional<String> name();
    Optional<String> url();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();

    /**
     * Builder of instances.
     */
    class Builder extends ToolConsumerInstance_Builder {
        public Builder() {
            contactEmail(Optional.empty());
            description(Optional.empty());
            guid(Optional.empty());
            name(Optional.empty());
            url(Optional.empty());
        }
    }

    static ToolConsumerInstance fromParams(ParamExtractor e) {
        return builder()
          .name(e.getFirst(TOOL_CONSUMER_INSTANCE_NAME))
          .contactEmail(e.getFirst(TOOL_CONSUMER_INSTANCE_CONTACT_EMAIL))
          .description(e.getFirst(TOOL_CONSUMER_INSTANCE_DESCRIPTION))
          .guid(e.getFirst(TOOL_CONSUMER_INSTANCE_GUID))
          .url(e.getFirst(TOOL_CONSUMER_INSTANCE_URL))
          .build();
    }
}
