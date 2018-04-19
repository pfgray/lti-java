package net.paulgray.lti.message;

import net.paulgray.lti.LtiVersion;
import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
public interface LtiLaunchContext {

    ToolConsumer consumer();
    Context context();
    LaunchPresentation presentation();
    LtiVersion version();
    MessageType messageType();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();
    /** Builder of instances. */
    class Builder extends LtiLaunchContext_Builder { }

}
