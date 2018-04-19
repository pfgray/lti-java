package net.paulgray.lti.message;

import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
public interface ConfigureLaunchRequestMessage extends LtiMessage {

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();

    /**
     * Builder of instances.
     */
    class Builder extends ConfigureLaunchRequestMessage_Builder {
        public Builder() {
            type(KnownMessageType.ConfigureLaunchRequest);
        }
    }

    static LtiErrorable<LtiMessage> fromLaunchContext(LtiLaunchContext launchContext, ParamExtractor e) {
        return LtiErrorable.success(
          net.paulgray.lti.message.ConfigureLaunchRequestMessage
            .builder()
            .version(launchContext.version())
            .build()
        );
    }
}
