package net.paulgray.lti.message;

import org.inferred.freebuilder.FreeBuilder;

import java.util.Optional;

@FreeBuilder
public interface ToolConsumer {

    Optional<ToolConsumerInfo> info();
    Optional<ToolConsumerInstance> instance();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();

    /** Builder of instances. */
    class Builder extends ToolConsumer_Builder {
        public Builder() {
            info(Optional.empty());
            instance(Optional.empty());
        }
    }

    static ToolConsumer fromParams(ParamExtractor e) {
        return builder()
          .info(ToolConsumerInfo.fromParams(e))
          .instance(ToolConsumerInstance.fromParams(e))
          .build();
    }
}
