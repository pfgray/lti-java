package net.paulgray.lti.message;

import org.inferred.freebuilder.FreeBuilder;

import java.util.Optional;

@FreeBuilder
public interface BasicLtiLaunchRequestMessage extends ConsumerBasedLaunch {

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();
    /** Builder of instances. */
    class Builder extends BasicLtiLaunchRequestMessage_Builder {
        public Builder() {
            type(KnownMessageType.BasicLtiLaunchRequest);
            toolConsumer(Optional.empty());
            context(Optional.empty());
            launchPresentation(Optional.empty());
        }
    }

    static LtiErrorable<LtiMessage> fromLaunchContext(LtiLaunchContext launchContext, ParamExtractor e) {
        return User.fromParams(e).map(user ->
          BasicLtiLaunchRequestMessage.builder()
            .user(user)
            .toolConsumer(launchContext.consumer())
            .context(launchContext.context())
            .launchPresentation(launchContext.presentation())
            .version(launchContext.version())
            .type(launchContext.messageType())
            .putAllCustomParameters(e.getParamsWithPrefix("custom_"))
            .putAllExtensionParameters(e.getParamsWithPrefix("ext_"))
            .build()
        );
    }

}
