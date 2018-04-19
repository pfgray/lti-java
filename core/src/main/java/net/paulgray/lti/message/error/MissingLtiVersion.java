package net.paulgray.lti.message.error;

/**
 * The launch didn't include an lti_version
 */
public class MissingLtiVersion implements LtiError {

    @Override
    public String getMessage() {
        return "The launch didn't include an lti_version";
    }
}
