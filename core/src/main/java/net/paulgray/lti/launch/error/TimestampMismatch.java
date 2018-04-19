package net.paulgray.lti.launch.error;

import java.time.Instant;

/**
 * The Timestamp included in the request does was not within range of the acceptable limit.
 */
public class TimestampMismatch implements OauthVerificationError {

    private Instant timestamp;

    public TimestampMismatch(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String getMessage() {
        return String.format("Timestamp mismatch, request's timestamp was: %s", timestamp);
    }
}
