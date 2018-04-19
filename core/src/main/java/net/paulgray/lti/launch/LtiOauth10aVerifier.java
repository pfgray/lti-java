package net.paulgray.lti.launch;

import net.oauth.*;
import net.oauth.server.OAuthServlet;
import net.oauth.signature.OAuthSignatureMethod;
import net.paulgray.lti.launch.error.InvalidSignature;
import net.paulgray.lti.launch.error.MissingBaseString;
import net.paulgray.lti.launch.error.MissingOauthKey;
import net.paulgray.lti.message.LtiErrorable;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * This class <b>verifies</b> LTI requests according to the Oauth 1.0a spec
 *
 */
public class LtiOauth10aVerifier implements LtiVerifier {

    public static final String OAUTH_KEY_PARAMETER = "oauth_consumer_key";

    private final static Logger log = Logger.getLogger(LtiOauth10aVerifier.class.getName());

    static {
        OAuthSignatureMethod.registerMethodClass("HMAC-SHA256", HMAC_SHA256.class);
    }

    /**
     * This method verifies the signed HttpServletRequest
     *
     * @param request the HttpServletRequest that will be verified
     * @param secret  the secret to verify the properties with
     * @return the result of the verification, along with contextual
     * information
     */
    @Override
    public LtiErrorable<HttpServletRequest> verify(HttpServletRequest request, String secret) {
        OAuthMessage oam = OAuthServlet.getMessage(request, OAuthServlet.getRequestURL(request));
        String oauth_consumer_key = null;
        try {
            oauth_consumer_key = oam.getConsumerKey();
        } catch (IOException e) {
            return LtiErrorable.error(new MissingOauthKey());
        }

        OAuthValidator oav = new SimpleOAuthValidator();
        OAuthConsumer cons = new OAuthConsumer(null, oauth_consumer_key, secret, null);
        OAuthAccessor acc = new OAuthAccessor(cons);

        // todo: do we want to enforce the base string being present?
        String base_string = null;
        try {
            base_string = OAuthSignatureMethod.getBaseString(oam);
        } catch (IOException | URISyntaxException e) {
            return LtiErrorable.error(new MissingBaseString());
        }

        try {
            oav.validateMessage(oam, acc);
        } catch (Exception e) {
            return LtiErrorable.error(new InvalidSignature(
              "<signature>",
              "<bodyHash>"
            ));
        }
        return LtiErrorable.success(request);
    }

    /**
     * This method will verify a collection of parameters
     *
     * @param parameters the parameters that will be verified. mapped by key &amp; value
     * @param url        the url this request was made at
     * @param method     the method this url was requested with
     * @param secret     the secret to verify the properties with
     * @return
     */
    @Override
    public LtiErrorable<Collection<? extends Map.Entry<String, String>>> verifyParameters(Collection<? extends Map.Entry<String, String>> parameters, String url, String method, String secret) {
        OAuthMessage oam = new OAuthMessage(method, url, parameters);
        Optional<String> key = parameters.stream()
          .filter(e -> e.getKey().equals(OAUTH_KEY_PARAMETER))
          .map(Map.Entry::getValue)
          .findFirst();

        if(!key.isPresent()) {
            return LtiErrorable.error(new MissingOauthKey());
        } else {
            String oauthKey = key.get();
            OAuthConsumer cons = new OAuthConsumer(null, oauthKey, secret, null);
            OAuthValidator oav = new SimpleOAuthValidator();
            OAuthAccessor acc = new OAuthAccessor(cons);

            try {
                oav.validateMessage(oam, acc);
            } catch (Exception e) {
                return LtiErrorable.error(new InvalidSignature(
                  "<signature>",
                  "<bodyHash>"
                ));
            }
            return LtiErrorable.success(parameters);
        }
    }
}
