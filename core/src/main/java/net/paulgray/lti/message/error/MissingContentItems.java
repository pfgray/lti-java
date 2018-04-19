package net.paulgray.lti.message.error;

/**
 * The launch didn't include a content_items parameter
 */
public class MissingContentItems implements LtiError {
    @Override
    public String getMessage() {
        return "The launch didn't include a content_items parameter";
    }
}
