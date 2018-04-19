package net.paulgray.lti.launch;

import net.oauth.OAuth;
import net.oauth.OAuthException;
import net.oauth.signature.OAuthSignatureMethod;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * HMAC-SHA256 Signature method
 */
public class HMAC_SHA256 extends OAuthSignatureMethod {

    public HMAC_SHA256() {}

    @Override
    protected String getSignature(String baseString) throws OAuthException {
        try {
            return base64Encode(computeSignature(baseString));
        } catch (Exception e) {
            throw new OAuthException(e);
        }
    }

    @Override
    protected boolean isValid(String signature, String baseString) throws OAuthException {
        try {
            return equals(computeSignature(baseString), decodeBase64(signature));
        } catch (Exception e) {
            throw new OAuthException(e);
        }
    }

    private byte[] computeSignature(String baseString) throws GeneralSecurityException, UnsupportedEncodingException {
        String keyString = OAuth.percentEncode(this.getConsumerSecret()) + '&' + OAuth.percentEncode(this.getTokenSecret());
        byte[] keyBytes = keyString.getBytes("UTF-8");
        SecretKey key = new SecretKeySpec(keyBytes, "HmacSHA256");

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        byte[] text = baseString.getBytes("UTF-8");
        return mac.doFinal(text);
    }
}
