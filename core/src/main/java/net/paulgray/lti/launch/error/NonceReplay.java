package net.paulgray.lti.launch.error;

/**
 * The nonce from the processed request has already been used in another request.
 */
public class NonceReplay implements OauthVerificationError {

    private String nonce;

    public NonceReplay(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public String getMessage() {
        return String.format("The nonce: %s has already been used in a previous request", nonce);
    }
}
