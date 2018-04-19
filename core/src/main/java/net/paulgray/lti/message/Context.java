package net.paulgray.lti.message;

import net.paulgray.lti.LtiConstants;
import org.inferred.freebuilder.FreeBuilder;

import java.util.Optional;

@FreeBuilder
public interface Context {

    Optional<String> id();
    Optional<String> label();
    Optional<String> title();
    Optional<String> type();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();

    /** Builder of instances. */
    class Builder extends Context_Builder {
        public Builder() {
            id(Optional.empty());
            label(Optional.empty());
            title(Optional.empty());
            type(Optional.empty());
        }
    }

    static Context fromParams(ParamExtractor e) {
        return builder()
          .id(e.getFirst(LtiConstants.CONTEXT_ID))
          .label(e.getFirst(LtiConstants.CONTEXT_LABEL))
          .type(e.getFirst(LtiConstants.CONTEXT_TYPE))
          .title(e.getFirst(LtiConstants.CONTEXT_TITLE))
          .build();
    }
}
