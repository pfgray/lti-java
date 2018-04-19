package net.paulgray.lti.launch;

import net.paulgray.lti.message.LtiErrorable;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * @author Paul Gray
 */
public class LtiVerifierAndSignerTest {

    LtiVerifier verifier = new LtiOauth10aVerifier();
    LtiSigner signer = new LtiOauth10aSigner();

    @Test
    public void verifierShouldVerifyCorrectlySignedLtiLaunches() throws Exception {

        String key = "key";
        String secret = "secret";
        HttpPost ltiLaunch = new HttpPost(new URI("http://example.com/test"));

        signer.sign(ltiLaunch, key, secret);
        LtiErrorable<HttpServletRequest> result = verifier.verify(new MockHttpPost(ltiLaunch), secret);

        assertTrue(result.getErrors().isEmpty());
    }

    @Test
    public void verifierShouldRejectIncorrectlySignedLtiLaunches() throws Exception {

        String key = "key";
        String secret = "secret";
        HttpPost ltiLaunch = new HttpPost(new URI("http://example.com/test"));

        signer.sign(ltiLaunch, key, secret);
        LtiErrorable<HttpServletRequest> result = verifier.verify(new MockHttpPost(ltiLaunch), "wrongSecret");

        assertFalse(result.getErrors().isEmpty());
    }

    @Test
    public void verifierShouldVerifyCorrectlySignedLtiGetServiceRequests() throws Exception {

        String key = "key";
        String secret = "secret";
        HttpGet ltiServiceGetRequest = new HttpGet(new URI("http://example.com/test"));

        signer.sign(ltiServiceGetRequest, key, secret);
        LtiErrorable<HttpServletRequest> result = verifier.verify(new MockHttpGet(ltiServiceGetRequest), secret);

        assertTrue(result.getErrors().isEmpty());
    }

    @Test
    public void verifierShouldRejectIncorrectlySignedLtiGetServiceRequests() throws Exception {

        String key = "key";
        String secret = "secret";
        HttpGet ltiServiceGetRequest = new HttpGet(new URI("http://example.com/test"));

        signer.sign(ltiServiceGetRequest, key, secret);
        LtiErrorable<HttpServletRequest> result = verifier.verify(new MockHttpGet(ltiServiceGetRequest), "anotherWrongSecret");

        assertFalse(result.getErrors().isEmpty());
    }

}
