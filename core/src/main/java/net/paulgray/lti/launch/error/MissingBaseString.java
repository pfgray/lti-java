package net.paulgray.lti.launch.error;

/**
 * The request did not include a base string.
 */
public class MissingBaseString implements OauthVerificationError {

    @Override
    public String getMessage() {
        return "The request did not include a base string";
    }
}
