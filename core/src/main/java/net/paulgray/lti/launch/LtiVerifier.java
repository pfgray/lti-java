package net.paulgray.lti.launch;


import net.paulgray.lti.message.LtiErrorable;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

/**
 * This interface contains methods that <b>verify</b> Lti Launches
 * and generic request parameters according to the LTI
 * specification.
 *
 */
public interface LtiVerifier {

    /**
     * This method will verify the HttpServletRequest.
     *
     * @param request the HttpServletRequest that will be verified
     * @param secret  the secret to verify the properties with
     * @return an LtiVerificationResult which will
     * contain information about the request (whether or
     * not it is valid, and if it is valid, contextual
     * information about the request).
     */
    LtiErrorable<HttpServletRequest>  verify(HttpServletRequest request, String secret);

    /**
     * This method will verify a list of properties (mapped by key &amp; value).
     *
     * @param parameters the parameters that will be verified. mapped by key &amp; value
     * @param url        the url this request was made at
     * @param method     the method this url was requested with
     * @param secret     the secret to verify the propertihes with
     * @return an LtiVerificationResult which will
     * contain information about the request (whether or
     * not it is valid, and if it is valid, contextual
     * information about the request).
     */
    LtiErrorable<Collection<? extends Map.Entry<String, String>>>  verifyParameters(Collection<? extends Map.Entry<String, String>> parameters, String url, String method, String secret);

}
