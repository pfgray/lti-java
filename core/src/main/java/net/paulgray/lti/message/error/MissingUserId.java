package net.paulgray.lti.message.error;

/**
 * The launch didn't include a user_id parameter
 */
public class MissingUserId implements LtiError {
    @Override
    public String getMessage() {
        return "The launch didn't include a user_id parameter";
    }
}
