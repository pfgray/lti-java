package net.paulgray.lti.message;

import static net.paulgray.lti.LtiConstants.*;
import org.inferred.freebuilder.FreeBuilder;

import java.util.Optional;

@FreeBuilder
public interface ToolConsumerInfo {

    Optional<String> productFamilyCode();
    Optional<String> version();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();

    /** Builder of instances. */
    class Builder extends ToolConsumerInfo_Builder {
        public Builder() {
            productFamilyCode(Optional.empty());
            version(Optional.empty());
        }
    }

    static ToolConsumerInfo fromParams(ParamExtractor e) {
        return builder()
          .version(e.getFirst(TOOL_CONSUMER_INFO_VERSION))
          .productFamilyCode(TOOL_CONSUMER_INFO_PRODUCT_FAMILY_CODE)
          .build();
    }
}
