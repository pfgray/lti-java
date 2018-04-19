package net.paulgray.lti.message;

import net.paulgray.lti.JsonUtils;
import net.paulgray.lti.LtiConstants;
import net.paulgray.lti.contentitem.ContentItemSelection;
import net.paulgray.lti.message.error.MalformedContentItems;
import net.paulgray.lti.message.error.MissingContentItems;
import org.inferred.freebuilder.FreeBuilder;

import static net.paulgray.lti.message.error.LtiError.MISSING_CONTENT_ITEMS;


@FreeBuilder
public interface ContentItemSelectionMessage extends LtiMessage {

    ContentItemSelection contentItems();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();
    /** Builder of instances. */
    class Builder extends ContentItemSelectionMessage_Builder {
        public Builder() {
            type(KnownMessageType.ContentItemSelection);
        }
    }

    static LtiErrorable<LtiMessage> fromLaunchContext(LtiLaunchContext launchContext, ParamExtractor e) {
        return LtiErrorable.from(e.getFirst(LtiConstants.CONTENT_ITEMS), MISSING_CONTENT_ITEMS)
          .flatMap(
              contentItemStr -> {
                  try {
                      return LtiErrorable.success(JsonUtils.getMapper().readValue(contentItemStr, ContentItemSelection.class));
                  } catch(Exception exc) {
                      return LtiErrorable.error(new MalformedContentItems(contentItemStr));
                  }
              }
          ).map(contentItems -> (
            ContentItemSelectionMessage
              .builder()
              .version(launchContext.version())
              .contentItems(contentItems)
              .build()
          ));
    }

}
