package net.paulgray.lti.launch.error;

/**
 * The expected signature did not match the provided one.
 */
public class InvalidSignature implements OauthVerificationError {

    private String signature;
    private String bodyHash;

    public InvalidSignature(String signature, String bodyHash) {
        this.signature = signature;
        this.bodyHash = bodyHash;
    }

    @Override
    public String getMessage() {
        return String.format("Error validating signature: %s for body hash: %s", signature, bodyHash);
    }
}
