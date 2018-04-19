package net.paulgray.lti.launch;

/**
 * An error that can result from either verifying the oauth signature of a launch,
 *   or validating the contents of an lti launch
 */
public interface LaunchError {

    String getMessage();
}
