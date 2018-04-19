package net.paulgray.lti.message;

import org.inferred.freebuilder.FreeBuilder;

// todo: should this extend consumer-based launch?
@FreeBuilder
public interface DashboardRequestMessage extends LtiMessage {

    static Builder builder() {
        return new DashboardRequestMessage.Builder();
    }

    Builder toBuilder();

    /**
     * Builder of instances.
     */
    class Builder extends DashboardRequestMessage_Builder {
        public Builder() {
            type(KnownMessageType.DashboardRequest);
        }
    }

    static LtiErrorable<LtiMessage> fromLaunchContext(LtiLaunchContext launchContext, ParamExtractor e) {
        return LtiErrorable.success(
            DashboardRequestMessage
              .builder()
              .version(launchContext.version())
              .build()
          );
    }

}
