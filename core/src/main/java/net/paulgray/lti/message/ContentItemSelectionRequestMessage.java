package net.paulgray.lti.message;

import org.inferred.freebuilder.FreeBuilder;

import java.util.Optional;

@FreeBuilder
public interface ContentItemSelectionRequestMessage extends ConsumerBasedLaunch {

    Optional<Boolean> acceptUnsigned();
    Optional<String> data();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();
    /** Builder of instances. */
    class Builder extends ContentItemSelectionRequestMessage_Builder {
        public Builder() {
            type(KnownMessageType.ContentItemSelectionRequest);
            toolConsumer(Optional.empty());
            context(Optional.empty());
            launchPresentation(Optional.empty());
            acceptUnsigned(Optional.empty());
            data(Optional.empty());
        }
    }

    static LtiErrorable<LtiMessage> fromLaunchContext(LtiLaunchContext launchContext, ParamExtractor e) {
        return User.fromParams(e).map(user ->
          ContentItemSelectionRequestMessage.builder()
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
