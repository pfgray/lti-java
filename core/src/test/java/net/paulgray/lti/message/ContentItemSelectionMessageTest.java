package net.paulgray.lti.message;

import net.paulgray.lti.KnownLtiVersion;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static net.paulgray.lti.launch.LaunchHelpers.e;

public class ContentItemSelectionMessageTest {

    @Test
    public void shouldBuildFromLaunchContext() {
        LtiLaunchContext context = LtiLaunchContext.builder()
          .consumer(ToolConsumer.builder().build())
          .context(Context.builder().build())
          .presentation(LaunchPresentation.builder().build())
          .version(KnownLtiVersion.One)
          .messageType(KnownMessageType.ContentItemSelection)
          .build();

        ParamExtractor extractor = new ParamExtractor(Arrays.asList(
          e("content_items", "{}"),
          e("custom_userid", "paul"),
          e("ext_thing", "test")
        ));

        LtiErrorable<LtiMessage> message = ContentItemSelectionMessage.fromLaunchContext(context, extractor);

        Assert.assertEquals(0, message.getErrors().size());
    }
}
