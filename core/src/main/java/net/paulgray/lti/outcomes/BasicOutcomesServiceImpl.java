package net.paulgray.lti.outcomes;

import net.paulgray.lti.launch.LtiSigner;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.http.HttpParameters;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class BasicOutcomesServiceImpl implements BasicOutcomesService {

    private LtiSigner ltiSigner;

    public BasicOutcomesServiceImpl(LtiSigner ltiSigner) {
        this.ltiSigner = ltiSigner;
    }

    @Override
    public Optional<HttpPost> signOutcomeMessage(OutcomesMessage message, String url, String key, String secret, Optional<String> algorithm) {
        try {

            // build a request
            String xmlBody = message.serialize();
            String alg = algorithm.orElse("SHA1");

            HttpParameters parameters = new HttpParameters();
            String hash = getBodyHash(xmlBody, alg);
            parameters.put("oauth_body_hash", URLEncoder.encode(hash, "UTF-8"));

            CommonsHttpOAuthConsumer signer = new CommonsHttpOAuthConsumer(key, secret);
            HttpPost request = new HttpPost(url);
            request.setHeader("Content-Type", "application/xml");
            request.setEntity(new StringEntity(xmlBody, "UTF-8"));
            signer.setAdditionalParameters(parameters);
            signer.sign(request);
            return Optional.of(request);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e) {
            // todo: log warning
            return Optional.empty();
        }
    }

    // todo: this should be in LtiOauth10aSigner???
    private static String getBodyHash(String postBody, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);

        md.update(postBody.getBytes());
        byte[] output = Base64.encodeBase64(md.digest());
        return new String(output);
    }
}
