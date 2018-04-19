package net.paulgray.lti.launch;

import net.paulgray.lti.KnownLtiVersion;
import net.paulgray.lti.UnknownLtiVersion;
import net.paulgray.lti.message.*;
import net.paulgray.lti.message.error.LtiError;
import net.paulgray.lti.message.error.MissingLtiVersion;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static net.paulgray.lti.message.error.LtiError.MISSING_LTI_VERSION;
import static net.paulgray.lti.message.error.LtiError.MISSING_MESSAGE_TYPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static net.paulgray.lti.launch.LaunchHelpers.*;

public class LtiMessageExtractorImplTest {

    private LtiErrorable<LtiMessage> extract(Map.Entry<String, String>... entries) {
        LtiMessageExtractorImpl extractor = new LtiMessageExtractorImpl();
        return extractor.extractLtiMessage(Arrays.asList(entries));
    }

    @Test
    public void extractsLaunches() {

        LtiErrorable<LtiMessage> launch =
          extract(
            e("user_id", "1234"),
            e("lti_version", "LTI-1p0"),
            e("lti_message_type", "basic-lti-launch-request")
          );

        assertEquals("A valid set of parameters should contain no errors", 0, launch.getErrors().size());

        assertTrue("A valid set of parameters should contain a message", launch.getEntity().isPresent());

        assertTrue("A launch with an lti_message_type value of 'basic-lti-launch-request' " +
            "should extract to a BasicLtiLaunchRequestMessage",
          BasicLtiLaunchRequestMessage.class.isAssignableFrom(launch.getEntity().get().getClass()));

        BasicLtiLaunchRequestMessage l = (BasicLtiLaunchRequestMessage) launch.getEntity().get();

        assertEquals("A user's id should be extracted correctly", "1234", l.user().id());
        assertEquals("The Lti version should be extracted correctly", KnownLtiVersion.One, l.version());
        assertEquals("The Lti message type should be extracted correctly", KnownMessageType.BasicLtiLaunchRequest, l.type());
    }

    @Test
    public void extractsExtensionMessageTypes() {

        LtiErrorable<LtiMessage> launch =
          extract(
            e("user_id", "1234"),
            e("lti_version", "LTI-1p0"),
            e("lti_message_type", "my-custom-extension-message-type")
          );

        assertNotNull(launch);

        assertEquals("A valid set of parameters should contain no errors", 0, launch.getErrors().size());

        assertTrue("A valid set of parameters should contain a message", launch.getEntity().isPresent());

        assertEquals(
          "Should extract extension message types",
          ExtensionMessageType.of("my-custom-extension-message-type"),
          launch.getEntity().get().type()
        );
    }

    @Test
    public void extractsUnknownLtiVersions() {

        LtiErrorable<LtiMessage> launch =
          extract(
            e("user_id", "1234"),
            e("lti_version", "LTI-5p8"),
            e("lti_message_type", "basic-lti-launch-request")
          );

        assertEquals(
          "Should extract unknown lti versions",
          UnknownLtiVersion.of("LTI-5p8"),
          launch.getEntity().get().version()
        );
    }

    @Test
    public void shouldCollectErrors() {

        LtiErrorable<LtiMessage> launch =
          extract(
            e("asdf", "1234"),
            e("ffgae", "asfdsf")
          );

        assertEquals(
          "Should collect all errors... " + StringUtils.join(launch.getErrors(), ", "),
          2,
          launch.getErrors().size()
        );

        assertTrue(
          "Should identify missing lti version",
          launch.getErrors().contains(MISSING_LTI_VERSION)
        );

        assertTrue(
          "Should identify missing message type",
          launch.getErrors().contains(MISSING_MESSAGE_TYPE)
        );
    }

}
