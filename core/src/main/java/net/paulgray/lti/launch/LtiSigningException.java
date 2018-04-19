package net.paulgray.lti.launch;

/**
 * This exception is thrown to indicate that there was an error when signing an LTI request.
 *
 */
public class LtiSigningException extends Exception {
    public LtiSigningException(String message, Exception exception) {
        super(message, exception);
    }
}
