package net.paulgray.lti.message;

import net.paulgray.lti.LtiVersion;

import java.util.Map;

public interface LtiMessage {

    LtiVersion version();
    MessageType type();
    Map<String, String> customParameters();
    Map<String, String> extensionParameters();

}
