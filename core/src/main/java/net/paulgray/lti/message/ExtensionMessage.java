package net.paulgray.lti.message;

import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
public interface ExtensionMessage extends LtiMessage {

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();

    /**
     * Builder of instances.
     */
    class Builder extends ExtensionMessage_Builder { }

    static LtiErrorable<LtiMessage> fromLaunchContext(LtiLaunchContext launchContext, ParamExtractor e) {
        return LtiErrorable.success(
          net.paulgray.lti.message.ConfigureLaunchRequestMessage
            .builder()
            .type(launchContext.messageType())
            .version(launchContext.version())
            .build()
        );
    }
}
