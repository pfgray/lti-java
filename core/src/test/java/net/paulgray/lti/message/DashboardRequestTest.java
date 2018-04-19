package net.paulgray.lti.message;

import net.paulgray.lti.KnownLtiVersion;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static net.paulgray.lti.launch.LaunchHelpers.e;

public class DashboardRequestTest {

    @Test
    public void shouldBuildFromLaunchContext() {
        LtiLaunchContext context = LtiLaunchContext.builder()
          .consumer(ToolConsumer.builder().build())
          .context(Context.builder().build())
          .presentation(LaunchPresentation.builder().build())
          .version(KnownLtiVersion.One)
          .messageType(KnownMessageType.DashboardRequest)
          .build();

        ParamExtractor extractor = new ParamExtractor(Arrays.asList(
          e("user_id", "1234"),
          e("custom_userid", "paul"),
          e("ext_thing", "test")
        ));

        LtiErrorable<LtiMessage> message = DashboardRequestMessage.fromLaunchContext(context, extractor);

        Assert.assertEquals(0, message.getErrors().size());
    }
}
