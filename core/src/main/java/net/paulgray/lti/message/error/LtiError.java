package net.paulgray.lti.message.error;

import net.paulgray.lti.launch.LaunchError;

public interface LtiError extends LaunchError {

    MissingLtiVersion MISSING_LTI_VERSION = new MissingLtiVersion();
    MissingUserId MISSING_USER_ID = new MissingUserId();
    MissingContentItems MISSING_CONTENT_ITEMS = new MissingContentItems();
    MissingMessageType MISSING_MESSAGE_TYPE = new MissingMessageType();

}
